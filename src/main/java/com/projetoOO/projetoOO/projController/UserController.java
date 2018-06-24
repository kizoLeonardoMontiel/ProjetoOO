package com.projetoOO.projetoOO.projController;

import com.projetoOO.projetoOO.Input.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.projetoOO.projetoOO.projModel.Usuario;
import com.projetoOO.projetoOO.projRepository.UsuarioRepository;

@Controller
@RequestMapping("/")

public class UserController {

    private UsuarioRepository userRepo;

    @Autowired
    public UserController(UsuarioRepository userRepo){
        this.userRepo = userRepo;
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public ModelAndView loginGet(@ModelAttribute("user") UserInput user) {
        ModelAndView mv = new ModelAndView("login/login");
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(value = "/login{id}", method = RequestMethod.GET)
    public String adicionaGet() {
        return "/login";
    }


    @RequestMapping(value = "/login{id}", method = RequestMethod.POST)
    public String adicionaCadastro(@PathVariable("id") Long id, Usuario usuario) {
        userRepo.save(usuario);
        return "redirect:/";
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public String usuarioGet() {
        return "usuario/usuario";
    }


    @RequestMapping(value = "/detalhe", method = RequestMethod.GET)
    public ModelAndView usuarioIDGet(@ModelAttribute("user") UserInput user) {
        ModelAndView m = new ModelAndView("usuario/detalheUsuario");
        m.addObject("user", user);
        return m;
    }

    @RequestMapping(value = "/usuario/detalheUsuario", method = RequestMethod.POST)
    public String usuarioIDPost(Usuario user) {
        return "redirect:/usuario/detalheUsuario";
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public ModelAndView usuarioCadastroGet(@ModelAttribute("user") UserInput user) {
        ModelAndView mc = new ModelAndView("usuario/cadastro");
        mc.addObject("user", user);
        return mc;
    }



}
