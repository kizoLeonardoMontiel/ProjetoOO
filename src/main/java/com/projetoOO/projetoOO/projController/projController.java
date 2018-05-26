package com.projetoOO.projetoOO.projController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class projController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/evento")
	public String evento() {
		return "evento";
	}
	
	@GetMapping("/evento/{ID}")
	public String eventoID() {
		return null;
	}
}
