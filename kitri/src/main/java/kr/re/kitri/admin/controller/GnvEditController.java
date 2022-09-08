package kr.re.kitri.admin.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.re.kitri.admin.AdminBase;
import kr.re.kitri.kitri.dao.NavigationDAO;

@Controller
public class GnvEditController extends AdminBase {
	
	@Autowired
	private NavigationDAO dao;
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping("/gnv/edit")
	public void test(HttpServletRequest request, HttpServletResponse responese) {
		
		File file = new File(context.getRealPath("/WEB-INF/tiles/layout/kitri/kitri_gnv.jsp"));
		
		String baseLink = request.getContextPath() + "/kitri/";
		String enter = "\r\n";
		String tab = "\t";
		
		
		StringBuffer buffer = new StringBuffer();
		
		List<Map<String, String>> categorys = dao.getCategory();
		Map<String, String> t;
		List<Map<String, String>> pages;
		
		buffer.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>");
		buffer.append(enter);
		buffer.append("<h1> GNV 변경 테스트 </h1>");
		buffer.append(enter);
		
		
		for (int i = 0; i < categorys.size(); i++) {
			
			t = categorys.get(i);
			
			buffer.append("<p style=\"display:inline-block; vertical-align:top; margin : auto 20px;\">");
			buffer.append(enter);
			buffer.append(tab);
			buffer.append(t.get("name"));
			buffer.append(enter);
			buffer.append(tab);
			buffer.append("<br>");
			
			pages = dao.getCategoryPage((String) t.get("path_value"));
			
			for (int j = 0; j < pages.size(); j++) {
				buffer.append(enter);
				buffer.append(tab);
				buffer.append("<a href=\"");
				buffer.append(baseLink);
				buffer.append(pages.get(j).get("path_value"));
				buffer.append("/");
				buffer.append(pages.get(j).get("view_name"));
				buffer.append("\">");
				buffer.append(pages.get(j).get("name"));
				buffer.append("</a>");
				buffer.append(enter);
				buffer.append(tab);
				buffer.append("<br>");
			}
			buffer.append(enter);
			buffer.append("</p>");
			buffer.append(enter);
		}

		String html = buffer.toString();
		
		// 파일 없을 때 처리 추가 필요
		try {
			
			System.out.println(file.getPath());
			OutputStream stream = new FileOutputStream(file);
			Writer writer = new OutputStreamWriter(stream, "UTF-8");
			
			writer.write(html);
			writer.close();
			stream.flush();
			stream.close();
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			responese.sendRedirect(baseLink);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
