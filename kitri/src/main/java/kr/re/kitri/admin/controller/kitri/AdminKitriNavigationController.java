package kr.re.kitri.admin.controller.kitri;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.re.kitri.admin.service.kitri.AdminKitriNavigationService;

@Controller
@RequestMapping("/admin/kitri")
public class AdminKitriNavigationController {
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private AdminKitriNavigationService service;
	
	@RequestMapping("/gnv")
	public String list(Model model) {
		model.addAttribute("json", service.getKitriNavigationJson());
		return "admin/kitri/gnv";
	}
	
	@RequestMapping("/gnv/write")
	public void write(HttpServletResponse response, HttpServletRequest request) {
		
		boolean flag = false;
		
		try {
			File file = new File(context.getRealPath("/resources/js/sitemap.json"));
			
			if(!file.exists()) {
				file.createNewFile();
			}
			
			String json = service.getKitriNavigationJson();
			
			OutputStream out = new FileOutputStream(file);
			Writer writer = new OutputStreamWriter(out);
			writer.write(json);
			
			writer.flush();
			writer.close();
			out.close();
			
			flag = true;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		String msg;
		
		if(flag) {
			msg = "네비게이션 수정에 성공 했습니다.";
		}
		else {
			msg = "'네비게이션 수정에 실패 했습니다.'";
		}
		
		// alert 처리
		try {
			response.setContentType("text/html; charset=UTF-8;");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('" + msg + "');");
			script.println("location.href='" + context.getContextPath() + "/admin/kitri/gnv';");
			script.println("</script>");
			script.flush();
			script.close();
		} 
		catch (IOException e) {

			e.printStackTrace();
		}
	}
}
