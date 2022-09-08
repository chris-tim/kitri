package kr.re.kitri.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import javassist.NotFoundException;
import kr.re.kitri.admin.vo.AdminVO;

public class AdminIntercepter implements HandlerInterceptor  {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		AdminVO adminVO = (AdminVO) session.getAttribute("admin");
		
		if(adminVO != null && adminVO.adminCheck()) {
			return HandlerInterceptor.super.preHandle(request, response, handler);
		}
		else {
			throw new NotFoundException("관리자 인터셉터 처리");
		}	
	}
}
