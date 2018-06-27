package com.projetoOO.projetoOO.projController;

import com.projetoOO.projetoOO.Input.UserInput;
import com.projetoOO.projetoOO.projModel.Role;
import com.projetoOO.projetoOO.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.projetoOO.projetoOO.projModel.Usuario;
import com.projetoOO.projetoOO.projRepository.UsuarioRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetoOO.projetoOO.projRepository.RoleRepository;
import com.projetoOO.projetoOO.service.SecurityService;

import java.util.HashSet;
import java.util.Set;

@Controller
//@RequestMapping("/usuario")
public class UserController {



    @Autowired
	UsuarioRepository userRepo;

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    private ModelMapper mapper = new ModelMapper();

    @GetMapping("usuario/novoUsuario")
    public ModelAndView newUserForm(@ModelAttribute("user") UserInput user){
        ModelAndView mv = new ModelAndView("usuario/novoUsuario");
        mv.addObject("user", user);


        return mv;
    }

     @PostMapping("usuario/novoUsuario")
     public String newUser(UserInput userInput, RedirectAttributes redirectAttrs){
         Usuario usuario = userRepo.findByUsername(userInput.getUsername());

         Role role = roleRepository.findByRole("ROLE_USER");
         Usuario user = mapper.map(userInput, Usuario.class);
         Set<Role> roles = new HashSet<>();
         roles.add(role);
         user.setRoles(roles);
         userService.saveUser(user);

         redirectAttrs.addFlashAttribute("success", "Usuário cadastrado com sucesso. Você já pode entrar no sistema.");
         return "redirect:/index";
     }
    // aqui
    @RequestMapping("/detalhe")
    public ModelAndView usuarioIDGet(@ModelAttribute("user") UserInput user) {
        ModelAndView m = new ModelAndView("usuario/detalheUsuario");
        Iterable<Usuario> usuarios = userRepo.findAll();
        m.addObject("user",user);
        return m;
    }

    @RequestMapping(value="/usuario/detalheUsuario",method=RequestMethod.POST)
    public String usuarioIDPost(Usuario user) {
        userRepo.save(user);
        return "redirect:usuario/detalheUsuario";
    }

    @RequestMapping(value="/cadastro",method={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView usuarioCadastroGet(@ModelAttribute("user") UserInput user) {
        ModelAndView mc = new ModelAndView("usuario/cadastro");
        mc.addObject("user", user);
        return mc;
    }

    @RequestMapping(value="/usuario/cadastro",method=RequestMethod.POST)
    public String usuarioCadastroPost(Usuario user) {
        userRepo.save(user);
        return "redirect:usuario/cadastro";
    }
    //ate aqui
}
