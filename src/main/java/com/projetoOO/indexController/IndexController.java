package com.projetoOO.indexController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    
    @RequestMapping("/test")
    public String test() {
    	return "test";
    }
}
