package com.projetoOO.projetoOO.projController;

import com.projetoOO.projetoOO.Input.UserInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.projetoOO.projetoOO.projModel.Usuario;
import com.projetoOO.projetoOO.projRepository.UsuarioRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetoOO.projetoOO.config.stringConstants;
import com.projetoOO.projetoOO.config.RedirectConstants;

@Controller
//@RequestMapping("/usuario")
public class UserController {

    @Autowired
	UsuarioRepository userRepo;

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

        Usuario user = mapper.map(userInput, Usuario.class);
        userRepo.save(user);

        redirectAttrs.addFlashAttribute("success", "Usuário cadastrado com sucesso. Você já pode entrar no sistema.");
        return "redirect:/";
    }
    // aqui
    @RequestMapping(value="/detalhe",method=RequestMethod.GET)
    public ModelAndView usuarioIDGet(@ModelAttribute("user") UserInput user) {
        ModelAndView m = new ModelAndView("usuario/detalheUsuario");
        m.addObject("user",user);
        return m;
    }

    @RequestMapping(value="/usuario/detalheUsuario",method=RequestMethod.POST)
    public String usuarioIDPost(Usuario user) {
        userRepo.save(user);
        return "redirect:usuario/detalheUsuario";
    }

    @RequestMapping(value="/cadastro",method=RequestMethod.GET)
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

    /*@GetMapping("/cadastro")
    public ModelAndView detalheUsuario(@PathVariable("id") Long idUsuario, RedirectAttributes redirectAttrs){
        Usuario usuario = userRepo.findById(idUsuario).get();

        if (usuario == null) {
            redirectAttrs.addFlashAttribute(stringConstants.ERROR, "O usuário solicitado não existe.");
            return new ModelAndView(RedirectConstants.REDIRECT_CADASTRO);
        }

        UserInput userInput = mapper.map(usuario, UserInput.class);

        ModelAndView mv = new ModelAndView("usuario/cadastro");
        //mv.addObject(stringConstants.USER_LOGGED, securityService.findLoggedInUser());
        mv.addObject("user", userInput);
        return mv;
    }
*/
  /*  @PostMapping(value = "/cadastro")
    public String salvarUsuario(@PathVariable("id") Long idUsuario, UserInput userInput, RedirectAttributes redirectAttrs) {
        Usuario usuario = userRepo.findById(idUsuario).get();


        usuario.setNome(userInput.getNome());
        usuario.setUsername(userInput.getUsername());
        if (userInput.getPassword().length() != 0) {
            usuario.setPassword(userInput.getPassword());
        }

        userRepo.save(usuario);

        redirectAttrs.addFlashAttribute(stringConstants.SUCCESS, "Usuário alterado com sucesso.");
        redirectAttrs.addFlashAttribute("usuario", userInput);
        return RedirectConstants.REDIRECT_CADASTRO + idUsuario;
    }
*/
}
