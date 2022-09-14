package kr.re.kitri.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.re.kitri.admin.AdminBase;
import kr.re.kitri.admin.vo.AdminVO;

@Controller
@RequestMapping(value = "/admin/main")
public class AdminMainController extends AdminBase {

	@RequestMapping(value = {"" ,"/", "/main"})
	public String main(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.getAttribute("admin");
		
		AdminVO adminVO = (AdminVO) session.getAttribute("admin");
		
	
		if(adminVO != null && adminVO.adminCheck()) {
			return "";
		}
		else {
			return ADMIN_PREFIX + "main/main";
		}
	
	}
}
