package kr.re.kitri.common.service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.re.kitri.common.dto.MailDTO;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private FileService fileService;
	
	// DTO값 확인해서 메소드 지정
	public boolean mailSend(MailDTO dto) {
		
		if(dto.isSimple()) {
			return this.simpleMailSend(dto);
		}
		else {
			return this.mimeMailSend(dto);
		}
	}

	private boolean simpleMailSend(MailDTO dto) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
		
			message.setReplyTo(dto.getReplayTo());
			message.setTo(dto.getTo());
			message.setCc(dto.getCc());
			message.setBcc(dto.getBcc());
			message.setSubject(dto.getTitle());
			message.setText(dto.getContent());
			
			mailSender.send(message);
			return true;
		}
		catch (MailSendException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean mimeMailSend(MailDTO dto) {
		
		List<String> fileNames = null;	
		Set<String> keyset;
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true ,"UTF-8");
			
			// 메일 기본 설정
			helper.setReplyTo(dto.getReplayTo());
			helper.setFrom(dto.getFrom(), dto.getFromName());
			helper.setTo(dto.getTo());
			helper.setCc(dto.getCc());
			helper.setBcc(dto.getBcc());
			helper.setSubject(MimeUtility.encodeText(dto.getTitle(), "UTF-8", "B"));
			
			
			// 첨부파일 처리
			List<MultipartFile> attachments = dto.getAttachments();
			if(attachments != null) {
								
				DataSource dataSource;
				
				fileNames = new LinkedList<String>();
				String fileName;
				
				for(MultipartFile multipartFile : attachments) {
					// 내용 없는 객체가 생성되서 조건 변경
					if(multipartFile.getSize() > 0) {
						// 파일 업로드
						fileName = fileService.fileUpload(multipartFile, null);
						dataSource = new FileDataSource(fileName);
						fileNames.add(fileName);
						// 본문에 첨부파일 삽입
						helper.addAttachment(multipartFile.getOriginalFilename(), dataSource);
					}
				}
			}
			
			String regex = "src=\"";
			String regex2 = "\">";
			String content = dto.getContent();
			Map<String, FileDataSource> imageDatas = null;
			
			if(content.contains(regex)) {
				
				imageDatas = new LinkedHashMap<String, FileDataSource>();
				StringBuffer contentBuffer = new StringBuffer();
				String imgId;
				FileDataSource imageData;
				
				String[] temp;
				String[] temp2;
				
				temp = content.split(regex);
				contentBuffer.append(temp[0]);
				
				
				for(int i = 1; i<temp.length; i++) {
					
					temp2 = temp[i].split(regex2);
					imgId = "image"+i;
					imageData = new FileDataSource(fileService.getOSPath(temp2[0]));
					imageDatas.put(imgId, imageData);
					contentBuffer.append(regex);
					contentBuffer.append("cid:"+imgId);
					for(int j = 1; j< temp2.length; j++) {
						contentBuffer.append(regex2);
						contentBuffer.append(temp2[j]);
					}
				}
				content = contentBuffer.toString();
			}
			
			helper.setText(content, true);
			
			//추출한 이미지 본문에 삽입
			if(imageDatas != null) {
				keyset = imageDatas.keySet();
				
				for(String key : keyset) {
					helper.addInline(key, imageDatas.get(key));
				}
			}
			
			mailSender.send(message);
			
			// 첨부파일 서버에서 제거
			for(String fileName : fileNames) {
				System.out.println(fileName);
				fileService.fileDelete(fileName);
			}
			return true;
		}
		catch (MessagingException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
