package kr.re.kitri.util;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import kr.re.kitri.dto.MailDTO;

@Service
public class MailSendUtil {
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private ServletContext context;
	
	public boolean mailSned(MailDTO dto) {
		
		if(dto.isSimple()) {
			return simpleMailSend(dto);
		}
		else {
			return mailSend(dto);
		}
	}
	
	private boolean simpleMailSend(MailDTO dto) {
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
		
			message.setReplyTo(dto.getReplayTo());
			message.setTo(dto.getTo());
			message.setSubject(dto.getSubject());
			message.setText(dto.getContent());
			
			sender.send(message);
			
			return true;
		}
		catch (MailSendException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean mailSend(MailDTO dto) {
		
		Set<String> keyset;
		
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true ,"UTF-8");
			
			// 메일 기본 설정
			helper.setTo(dto.getTo());
			helper.setReplyTo(dto.getReplayTo());
			helper.setSubject(MimeUtility.encodeText(dto.getSubject(), "UTF-8", "B"));
			
			Map<String, DataSource> attachments = dto.getAttachments();
			
			if(attachments != null ) {
				
				keyset = attachments.keySet();
				
				// 첨부파일 처리
				for(String key : keyset) {
					helper.addAttachment(MimeUtility.encodeText(key, "UTF-8", "B"), dto.getAttachments().get(key));
				}
			}
			
			// 이미지 처리
			String regex = "<img src=\"";
			String regex2 = "\"";
			String content = dto.getContent();
			Map<String, FileDataSource> imageDatas = null;
			
			if(content.contains(regex)) {
				
				imageDatas = new LinkedHashMap<String, FileDataSource>();
				StringBuffer contentBuffer = new StringBuffer();
				String imgId;
				
				/*
				 * [0] <img src=" 이전내용
				 * [1] 경로\"> ~ <img src=" 이전내용 반복
				 */
				String[] temp;
				/*
				 *  [0] 웹상 이미지경로
				 *  [1] 나머지 내용 
				 */
				String[] temp2;
				
				temp = content.split(regex);
				contentBuffer.append(temp[0]);
				
				for(int i = 1; i<temp.length; i++) {
					temp2 = temp[i].split(regex2);
					imgId = "image"+i;
					imageDatas.put(imgId, new FileDataSource(context.getRealPath(temp2[0].replace("/kitri", ""))));
					contentBuffer.append(regex);
					contentBuffer.append("cid:");
					contentBuffer.append(imgId);
					contentBuffer.append(regex2);
					contentBuffer.append(temp2[1]);					
				}
				
				content = contentBuffer.toString();
			}
			
			helper.setText(content, true);
			
			//추출한 이미지 메일본문에 삽입
			if(imageDatas != null) {
				keyset = imageDatas.keySet();
				
				for(String key : keyset) {
					helper.addInline(key, imageDatas.get(key));
				}
			}
			
			sender.send(message);
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
