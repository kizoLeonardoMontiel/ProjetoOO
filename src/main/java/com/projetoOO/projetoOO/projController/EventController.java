package com.projetoOO.projetoOO.projController;

import com.projetoOO.projetoOO.Input.EventInput;
import com.projetoOO.projetoOO.projModel.Eventos;
import com.projetoOO.projetoOO.projModel.Usuario;
import com.projetoOO.projetoOO.projRepository.EventosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EventController {
	@Autowired
	EventosRepository eventRepo;

    private ModelMapper mapper = new ModelMapper();

    @GetMapping("/evento")
    public ModelAndView newUserForm(@ModelAttribute("event") EventInput event){
        ModelAndView mv = new ModelAndView("evento/evento");
        mv.addObject("event", event);
        return mv;
    }

    @PostMapping("/evento")
    public String newEve(EventInput eventInput, RedirectAttributes redirectAttrs){
        Eventos eventos = eventRepo.findByEventos(eventInput.getNome_Evento());

        Eventos event = mapper.map(eventInput, Eventos.class);
        eventRepo.save(eventos);

        redirectAttrs.addFlashAttribute("success", "Evento cadastrado com sucesso.");
        return "redirect:/";
    }

	@RequestMapping("/evento")
	public ModelAndView listaEventos() {
		ModelAndView m = new ModelAndView("evento/evento");
		Iterable<Eventos> events = eventRepo.findAll();
		m.addObject("eventos", events); //na view, utilizar o nome "eventos"
		return m;
	}
	
	@RequestMapping(value="/evento/{ID}",method=RequestMethod.GET)
	public ModelAndView eventoIDGet(@PathVariable("id") long id) {
		Eventos events = eventRepo.findById(id);
		ModelAndView m = new ModelAndView("evento/detalheEvento");
		m.addObject("eventos",events);
		return m;
	}
	
	@RequestMapping(value="/evento/{ID}",method=RequestMethod.POST)
	public String eventoIDPost(@PathVariable("id") long id) {
		Eventos events = eventRepo.findById(id);
		eventRepo.save(events);
		return "redirect:/{id}";
	}
	
	@RequestMapping(value="/evento/{ID}/delete",method=RequestMethod.GET)
	public ModelAndView eventoIDDelete(@PathVariable("id") long id, Usuario usuario) {
		Eventos events = eventRepo.findById(id);
		ModelAndView m = new ModelAndView("evento/deletaEvento");
		m.addObject("eventos",events);
		return m;
	}
}
