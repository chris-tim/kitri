package kr.re.kitri.admin.controller;

import java.io.IOException;

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

@Controller
@RequestMapping("/mail")
public class MailSendController {
	
	@Autowired
	JavaMailSender sender;
	
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
}
