package com.projetoOO.projetoOO.projController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {
	@RequestMapping("/evento")
	public String eventoRequest() {
		return "evento/evento";
	}

	@GetMapping("/evento/{ID}")
	public String eventoIDGet() {
		return null;
	}
	
	@PostMapping("/evento")
	public String eventoPost() {
		return null;
	}
	
	@PostMapping("/evento/{ID}")
	public String eventoIDPost() {
		return null;
	}
	
	@GetMapping("/evento/{ID}/delete")
	public String eventoIDDeleteGet() {
		return null;
	}

}
