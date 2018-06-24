package com.projetoOO.projetoOO.projController;

import com.projetoOO.projetoOO.Input.SubmissionInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projetoOO.projetoOO.projModel.Submissoes;
import com.projetoOO.projetoOO.projRepository.SubmissoesRepository;

@Controller
public class SubmissionController {
	@Autowired
	public SubmissoesRepository submissionRepo;

	@RequestMapping(value="/submissoes",method=RequestMethod.GET)
	public String submissoesGet() {
		return "submissoes/submissoes";
	}

	@RequestMapping(value="/mostra",method=RequestMethod.GET)
	public ModelAndView submissoesIDGet(@ModelAttribute("submission") SubmissionInput submission) {
		ModelAndView m = new ModelAndView("submissoes/mostraSubmissoes");
		m.addObject("submissoes",submission);
		return m;
	}

	@RequestMapping(value="/submissoes/mostraSubmissoes",method=RequestMethod.POST)
	public String submissoesIDPost(Submissoes submission) {
		submissionRepo.save(submission);
		return "redirect:/submissoes/mostraSubmissoes";
	}
	
	
	@RequestMapping(value="/submissoes/{ID}/delete",method=RequestMethod.GET)
	public ModelAndView submissoesIDDelete(@PathVariable("id") long id) {
		Submissoes submission = submissionRepo.findById(id);
		ModelAndView m = new ModelAndView("submissoes/deletaSubmissao");
		m.addObject("submissoes",submission);
		return m;
	}
	
	@RequestMapping(value="/submete",method=RequestMethod.GET)
	public ModelAndView submissoesEventoIDGet(@ModelAttribute("submission") SubmissionInput submission) {
		ModelAndView m = new ModelAndView("submissoes/evento/submeteEvento");
		m.addObject("submission", submission);
		return m;
	}
	
	@RequestMapping(value="/submissoes/evento/submeteEvento",method=RequestMethod.POST)
	public String submissoesEventoIDPost(Submissoes submission) {
        submissionRepo.save(submission);
		return "redirect:/submissoes/evento/submeteEvento";
	}
	

}
