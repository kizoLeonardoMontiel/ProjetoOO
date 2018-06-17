package com.projetoOO.projetoOO.projController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projetoOO.projetoOO.projModel.Eventos;
import com.projetoOO.projetoOO.projModel.Submissoes;
import com.projetoOO.projetoOO.projModel.Usuario;
import com.projetoOO.projetoOO.projRepository.EventosRepository;
import com.projetoOO.projetoOO.projRepository.SubmissoesRepository;

@Controller
public class SubmissionController {
	@Autowired
	public SubmissoesRepository submissionRepo;
	@Autowired
	public EventosRepository eventRepo;
	
	@RequestMapping(value="/submissoes",method=RequestMethod.GET)
	public String submissoesGet() {
		return "submissoes/submissoes";
	}
		
	@RequestMapping(value="/submissoes/{ID}",method=RequestMethod.GET)
	public ModelAndView submissoesIDGet(@PathVariable("id") long id) {
		Submissoes submission = submissionRepo.findById(id);
		ModelAndView m = new ModelAndView("submissoes/mostraSubmissoes");
		m.addObject("submissoes",submission);
		return m;
	}

	@RequestMapping(value="/submissoes/{ID}",method=RequestMethod.POST)
	public String submissoesIDPost(@PathVariable("id") long id) {
		Submissoes submission = submissionRepo.findById(id);
		submissionRepo.save(submission);
		return "redirect:/{id}";
	}
	
	
	@RequestMapping(value="/submissoes/{ID}/delete",method=RequestMethod.GET)
	public ModelAndView submissoesIDDelete(@PathVariable("id") long id) {
		Submissoes submission = submissionRepo.findById(id);
		ModelAndView m = new ModelAndView("submissoes/deletaSubmissao");
		m.addObject("submissoes",submission);
		return m;
	}
	
	@RequestMapping(value="/submissoes/evento/{idEvento}",method=RequestMethod.GET)
	public ModelAndView submissoesEventoIDGet(@PathVariable("idEvento") long idEvento) {
		Eventos event = eventRepo.findById(idEvento);
		ModelAndView m = new ModelAndView("submissoes/evento/submeteEvento");
		m.addObject("event",event);
		return m;
	}
	
	@RequestMapping(value="/submissoes/evento/{idEvento}",method=RequestMethod.POST)
	public String submissoesEventoIDPost(@PathVariable("idEvento") long idEvento) {
		Eventos event = eventRepo.findById(idEvento);
		eventRepo.save(event);
		return "redirect:/submissoes";
	}
	

}
