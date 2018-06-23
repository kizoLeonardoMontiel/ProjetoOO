package com.projetoOO.projetoOO.projController;

import com.projetoOO.projetoOO.projModel.Eventos;
import com.projetoOO.projetoOO.projModel.Usuario;
import com.projetoOO.projetoOO.projRepository.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {
	@Autowired
	private EventosRepository eventRepo;

	
	@RequestMapping(value="/evento",method=RequestMethod.GET)
	public String eventoGet() {
		return "evento/evento";
	}

	@RequestMapping(value="/evento",method=RequestMethod.POST)
	public String eventoPost(Eventos event) {
		eventRepo.save(event);
		return "redirect:/evento";
	}
	
	@RequestMapping("/evento")
	public ModelAndView listaEventos() {
		ModelAndView m = new ModelAndView("evento/evento");
		Iterable<Eventos> events = eventRepo.findAll();
		m.addObject("eventos", events); //na view, utilizar o nome "eventos"
		return m;
	}

	@RequestMapping(value="/evento/{ID}",method=RequestMethod.GET)
	public ModelAndView eventoIDGet(@RequestParam("id") long id) {
		Eventos events = eventRepo.findById(id);
		ModelAndView m = new ModelAndView("evento/detalheEvento");
		m.addObject("eventos",events);
		return m;
	}

	@RequestMapping(value="/evento/{ID}",method=RequestMethod.POST)
	public String eventoIDPost(@RequestParam("id") long id) {
		Eventos events = eventRepo.findById(id);
		eventRepo.save(events);
		return "redirect:/{id}";
	}

	@RequestMapping(value="/evento/{ID}/delete",method=RequestMethod.GET)
	public ModelAndView eventoIDDelete(@RequestParam("id") long id, Usuario usuario) {
		Eventos events = eventRepo.findById(id);
		ModelAndView m = new ModelAndView("evento/deletaEvento");
		m.addObject("eventos",events);
		return m;
	}
}
