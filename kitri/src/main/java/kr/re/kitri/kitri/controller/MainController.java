package kr.re.kitri.kitri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.re.kitri.kitri.KitriBase;

@Controller
@RequestMapping(value = "/kitri")
public class MainController extends KitriBase {
	
	@GetMapping(value = {"", "/", "/main"})
	public String main(Model model) {
				
		return KITRI_PREFIX + "main";
	}
}
