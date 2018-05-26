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
	public String eventoRequest() {
		return "evento";
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
	@GetMapping("/usuario/{ID}")
	public String usuarioIDGet() {
		return null;
	}
	
	@GetMapping("/usuario/cadastro")
	public String usuarioCadastroGet() {
		return null;
	}
	
	@PostMapping("/usuario/cadastro")
	public String usuarioCadastroPost(){
		return null;
	}

	@GetMapping("/submissoes")
	public String submissoesGet() {
		return null;
	}
	
	@RequestMapping("/submissoes")
	public String submissoesRequest() {
		return "submissoes";
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
	
	@RequestMapping("/usuario")
	public String usuarioRequest(){
		return "usuario";
	}
}
