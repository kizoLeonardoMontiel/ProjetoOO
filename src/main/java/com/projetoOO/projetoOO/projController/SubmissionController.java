package com.projetoOO.projetoOO.projController;

import com.projetoOO.projetoOO.Input.EventInput;
import com.projetoOO.projetoOO.Input.SubmissionInput;
import com.projetoOO.projetoOO.projModel.Eventos;
import com.projetoOO.projetoOO.service.SubmissaoServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.projetoOO.projetoOO.projModel.Submissoes;
import com.projetoOO.projetoOO.projRepository.SubmissoesRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SubmissionController {

	@Autowired
	SubmissoesRepository submissionRepo;

	@Autowired
	private SubmissaoServices submissaoservices;

	private ModelMapper mapper = new ModelMapper();


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
		ModelAndView mc = new ModelAndView("submissoes/evento/submeteEvento");
		mc.addObject("submission", submission);
		return mc;
	}



	@RequestMapping(value="/submete",method=RequestMethod.POST)
	public String submissoesEventoIDPost(Submissoes submission) {
        submissionRepo.save(submission);
		return "redirect:/submissoes/evento/submeteEvento";
	}
	

}
