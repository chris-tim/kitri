package kr.re.kitri.kitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.re.kitri.kitri.common.Nav;

@Controller
@RequestMapping(value = {"/kitri"})
public class MainController {
	
	@Autowired
	private Nav nav;
	
	
	@RequestMapping(value = {"", "/", "/main"})
	public String index(Model model) {		
		
		model.addAttribute("nav", nav.getNav());
		
		return "kitri/home";
	}
	

	@RequestMapping(value = "/{path}")
	public String test(@PathVariable String path, Model model) {
				
		model.addAttribute("nav", nav.getNav());
		
		return "kitri/"+path + ".editView";
	}
	
	@RequestMapping(value = "/{path}/{viewName}")
	public String test(@PathVariable String path, @PathVariable String viewName, Model model) {
				
		model.addAttribute("nav", nav.getNav());
		
		return "kitri/" + path + "/" + viewName + ".editView";
	}

}
