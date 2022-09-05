package kr.re.kitri.admin.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.re.kitri.dto.MailDTO;
import kr.re.kitri.util.MailSendUtil;

@Controller
@RequestMapping("/mail")
public class MailSendController {
	
	@Autowired
	JavaMailSender sender;
	
	@Autowired
	MailSendUtil util;
	
	String from = "khala0017@gmail.com";
	String to = "hsyeom@wemaginesoft.co.kr";
	
	String subject = "[스프링] 발송 테스트";

	// 텍스트 구성
	@RequestMapping("/send")
	public void mailSend(HttpServletRequest request, HttpServletResponse responese) {
		
		String content = "<p>이메일 발송 테스트</p>";
		
		// SimpleMailMessage 태그 적용 안됨
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		
		sender.send(message);
	}
	
	// 첨부파일
	@RequestMapping("/send2")
	public void mailSend2(HttpServletRequest request, HttpServletResponse responese) {
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true ,"UTF-8");
			String content = "<p>파일 <b>첨부</b> 테스트</p>";
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
			
			// true 설정시 html 태그로 인식
			helper.setText(content, false);
			
			ClassPathResource resource = new ClassPathResource("mybatis/mapper/testMapper.xml");
			
			DataSource dataSource = new FileDataSource(resource.getFile());
			helper.addAttachment(MimeUtility.encodeText("테스트_매퍼.xml", "UTF-8", "B"), dataSource);
			sender.send(message);
		} 
		catch (MessagingException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 본문에 이미지 삽입
	@RequestMapping("/send3")
	public void mailSend3(HttpServletRequest request, HttpServletResponse responese) {
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			
			String content = "<p>이미지 테스트<br><img src=\"cid:image\"></p>";
			
			helper.setFrom(from, "로컬");
			helper.setTo(to);
			helper.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
			
			helper.setText(content, true);
			helper.addInline("image", new FileDataSource(new ClassPathResource("155548.jpg").getFile()));
			
			sender.send(message);
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/dtoTest")
	public void send() {
		
		MailDTO dto = new MailDTO();
		String[] to = {"hsyeom@wemaginesoft.co.kr", "khala0017@gmail.com"};
		
		dto.setSubject("[로컬] 공통 기능 테스트");
		dto.setContent("공통 기능 테스트\r\r확인용");
		dto.setSimple(true);
		dto.setFromName("로컬 스프링");
		dto.setTo(to);
		
		util.mailSned(dto);
	}
	
	@RequestMapping("/dtoTest2")
	public void send2() {
		
		MailDTO dto = new MailDTO();
		ClassPathResource resource;
		Map<String, DataSource> attachments = new LinkedHashMap<String, DataSource>();
		
		try {
			
			DataSource dataSource;
			
			String[] to = {"hsyeom@wemaginesoft.co.kr", "khala0017@gmail.com"};
			
			dto.setSubject("[로컬] 공통 기능 테스트");
			dto.setFromName("로컬 스프링");
			dto.setTo(to);
			dto.setReplayTo("khala0017@gmail.com");
			
			resource = new ClassPathResource("155548.jpg");
			dataSource = new FileDataSource(resource.getFile());
			
			attachments.put("155548.jpg", dataSource);
			
			resource = new ClassPathResource("mybatis/config.xml");
			dataSource = new FileDataSource(resource.getFile());
			
			attachments.put("config.xml", dataSource);
			
			dto.setAttachments(attachments);
			
			StringBuffer buffer = new StringBuffer();
			buffer.append("<p>테스트 입니다.<br>");
			buffer.append("<img src=\"/kitri/resources/155548.jpg\">");
			buffer.append("</p>");
			buffer.append("<div>");
			buffer.append("<img src=\"/kitri/resources/155548.jpg\">");
			buffer.append("</div>");
			
			dto.setContent(buffer.toString());
			
			util.mailSned(dto);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
