package com.projetoOO.projetoOO.projController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projetoOO.projetoOO.projModel.Eventos;
import com.projetoOO.projetoOO.projModel.Usuario;
import com.projetoOO.projetoOO.projRepository.UsuarioRepository;

@Controller
public class UserController {
	@Autowired
	private UsuarioRepository userRepo;
	
	@RequestMapping(value="/usuario/{ID}",method=RequestMethod.GET)
	public ModelAndView usuarioIDGet(@PathVariable("id") long id) {
		Usuario user = userRepo.findById(id);
		ModelAndView m = new ModelAndView("usuario/detalheUsuario");
		m.addObject("usuario",user);
		return m;
	}
	
	@RequestMapping(value="/usuario/{ID}",method=RequestMethod.POST)
	public String usuarioIDPost(@PathVariable("id") long id) {
		Usuario user = userRepo.findById(id);
		userRepo.save(user);
		return "redirect:/{id}";
	}
	
	@RequestMapping(value="/usuario/cadastro",method=RequestMethod.GET)
	public String usuarioCadastroGet() {
		return "usuario/usuario";
	}
	
	@RequestMapping(value="/usuario/cadastro",method=RequestMethod.POST)
	public String usuarioCadastroPost(Usuario user) {
		userRepo.save(user);
		return "redirect:/usuario/cadastro";
	}
}
