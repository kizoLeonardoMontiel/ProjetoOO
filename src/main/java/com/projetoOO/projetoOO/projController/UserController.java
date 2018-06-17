package com.projetoOO.projetoOO.projController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/usuario")
	public String usuarioRequest(){
		return "usuario/usuario";
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

}
