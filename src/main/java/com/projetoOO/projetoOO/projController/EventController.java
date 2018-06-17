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
import com.projetoOO.projetoOO.projRepository.EventosRepository;

@Controller
public class EventController {
	@Autowired
	private EventosRepository eventRepo;
	//Página inicial dos eventos, mostra todos os eventos
	@RequestMapping(value="/evento",method=RequestMethod.GET)
	public String evento() {
		return "evento/evento";
	}
	//cria um novo evento
	@RequestMapping(value="/evento",method=RequestMethod.POST)
	public String evento(Eventos event) {
		eventRepo.save(event);
		return "redirect:/evento";
	}
	
	//Recebe a lista de eventos e renderiza na página eventos
	@RequestMapping("/evento")
	public ModelAndView listaEventos() {
		ModelAndView m = new ModelAndView("evento");
		Iterable<Eventos> events = eventRepo.findAll();
		m.addObject("eventos", events); //na view, utilizar o nome "eventos"
		return m;
	}
	
	@RequestMapping("/evento/{ID}")
	public ModelAndView eventoIDGet(@PathVariable("id") int id) {
		Eventos events = eventRepo.findById(id);
		ModelAndView m = new ModelAndView("detalhesEvento");
		m.addObject("eventos",events);
		return m;
	}
	
	
	
	@PostMapping("/evento/{ID}")
	public String eventoIDPost() {
		return null;
	}
	
	@GetMapping("/evento/{ID}/delete")
	public String eventoIDDeleteGet() {
		return null;
	}

}
