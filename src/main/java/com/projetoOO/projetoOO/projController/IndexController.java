package com.projetoOO.projetoOO.projController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView loginForm(){
        return new ModelAndView("login/login");
    }

    @GetMapping("/denied")
    public ModelAndView denied(){
        return new ModelAndView("denied");
    }
}
