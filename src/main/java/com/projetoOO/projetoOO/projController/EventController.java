package com.projetoOO.projetoOO.projController;

import com.projetoOO.projetoOO.projModel.Evento;
import com.projetoOO.projetoOO.projRepository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")

public class EventController {

	private EventoRepository eventoRepo;

    @Autowired
    public EventController(EventoRepository eventoRepo){
        this.eventoRepo = eventoRepo;
    }

    @RequestMapping(value = "/evento{id}", method = RequestMethod.GET)
    public String adicionaEventoGet(@PathVariable("id") Long id, Evento evento) {
        return "/";
    }

    @RequestMapping(value="/evento{id}",method = RequestMethod.POST)
    public String adicionaEvento(@PathVariable("id") Long id, Evento evento) {
        eventoRepo.save(evento);
        return "redirect:/";
    }

    /*@RequestMapping(value="/evento",method=RequestMethod.GET)
    public ModelAndView eventoGet(@ModelAttribute("eventos") EventInput eventos) {
            ModelAndView me = new ModelAndView("evento/evento");
            me.addObject("eventos", eventos);
            return me;
    }*/


    @RequestMapping("/evento")
    public ModelAndView listaEventos() {
        ModelAndView m = new ModelAndView("evento/evento");
        Iterable<Evento> evento = eventoRepo.findAll();
        m.addObject("evento", evento); //na view, utilizar o nome "eventos"
        return m;
    }

}
