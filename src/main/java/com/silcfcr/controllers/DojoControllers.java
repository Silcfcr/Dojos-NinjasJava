package com.silcfcr.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.silcfcr.models.Dojo;
import com.silcfcr.services.DojoService;


@Controller
public class DojoControllers {
	private final DojoService dojoService;

	public DojoControllers(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	
	@RequestMapping(value = "/addDojo", method=RequestMethod.GET)
	public String addDojo(@Valid @ModelAttribute( "dojo" ) Dojo dojo,
			   BindingResult result, RedirectAttributes redirectAttributes ) {
		return "Dojo.jsp";
	}
	
	@RequestMapping( value = "/createDojo", method = RequestMethod.POST )
	public String createDojo( @Valid @ModelAttribute( "dojo" ) Dojo dojo,
							   BindingResult result,
							   RedirectAttributes redirectAttributes ) {
		
		if ( result.hasErrors() ) {
			redirectAttributes.addFlashAttribute( "errorMessage", "You need to provide all details!" );
			System.out.println("I got here with error");
			//redirectAttributes.addFlashAttribute( "errorMessage", "You need to provide the identifier. The name must be lesser than 100 characters long!" );
		}
		else {
			dojoService.createDojo( dojo );	
			System.out.println("I got here with everything okay");
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/showDojo/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.getDojoById(id);
		model.addAttribute("dojo", dojo);
		return "/show.jsp";
	}
	
	
}
