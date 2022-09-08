package kr.re.kitri.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.re.kitri.common.dto.MailDTO;
import kr.re.kitri.common.service.MailService;

@Controller
@RequestMapping("/admin")
public class AdminMailController {
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping("/mail")
	public String mail() {
		return "admin/main/mail";
	}
	
	@PostMapping(value = "/mailSend", produces = "application/json;cahrset=UTF-8;")
	@ResponseBody
	public void mailSend(@ModelAttribute("mail") MailDTO dto) {
		mailService.mailSend(dto);
	}

}
