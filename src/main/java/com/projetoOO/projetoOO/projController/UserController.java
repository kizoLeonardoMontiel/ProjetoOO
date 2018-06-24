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
@RequestMapping("/usuario")
public class UserController {

    @Autowired
	UsuarioRepository userRepo;

    private ModelMapper mapper = new ModelMapper();

    @GetMapping("/novoUsuario")
    public ModelAndView newUserForm(@ModelAttribute("user") UserInput user){
        ModelAndView mv = new ModelAndView("usuario/novoUsuario");
        mv.addObject("user", user);
        return mv;
    }

    @PostMapping("/novoUsuario")
    public String newUser(UserInput userInput, RedirectAttributes redirectAttrs){
        Usuario usuario = userRepo.findByUsername(userInput.getUsername());

        Usuario user = mapper.map(userInput, Usuario.class);
        userRepo.save(user);

        redirectAttrs.addFlashAttribute("success", "Usuário cadastrado com sucesso. Você já pode entrar no sistema.");
        return "redirect:/";
    }

    @GetMapping("/{id}")
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

    @PostMapping("/{id}")
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

}
