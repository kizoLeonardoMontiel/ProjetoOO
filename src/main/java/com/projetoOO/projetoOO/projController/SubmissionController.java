package com.projetoOO.projetoOO.projController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SubmissionController {
	@RequestMapping("/submissoes")
	public String submissoesRequest() {
		return "submissoes/submissoes";
	}
	
	@GetMapping("/submissoes")
	public String submissoesGet() {
		return null;
	}
	
	@GetMapping("/submissoes/{ID}")
	public String submissoesIDGet() {
		return null;
	}
	
	@PostMapping("/submissoes/{ID}")
	public String submissoesIDPost() {
		return null;
	}
	
	@PostMapping("/submissoes/{ID}/delete")
	public String submissoesIDDeletePost() {
		return null;
	}
	
	@GetMapping("/submissoes/evento/{IDEvento}")
	public String submissoesEventoIDGet() {
		return null;
	}
	
	@PostMapping("/submissoes/evento/{IDEvento}")
	public String submissoesEventoIDPost() {
		return null;
	}

}
