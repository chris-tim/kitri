package kr.re.kitri.kitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.re.kitri.kitri.service.NavigationService;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class NavigationController {

	@Autowired
	private NavigationService service;

	@ResponseBody()
	@GetMapping("/kitri/nav")
	public String getNavigation() {
		return service.getNav();
	}
}
