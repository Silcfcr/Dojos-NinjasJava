package com.silcfcr.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.silcfcr.models.Dojo;
import com.silcfcr.models.Ninja;

import com.silcfcr.services.DojoService;
import com.silcfcr.services.NinjaService;

@Controller
public class NinjaControllers {
	
	private NinjaService ninjaService;
	private DojoService dojoService;

	public NinjaControllers(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	
	@RequestMapping(value = "/addNinja", method=RequestMethod.GET)
	public String addNinja(Model model) {
		
		
		System.out.println("hELLO");
		List<Dojo> DojoList = dojoService.getAllDojos();
		System.out.println(DojoList);
		if (DojoList == null) {
			System.out.println(DojoList + "is null");
			return "Ninja.jsp";	

		}
		else {
			model.addAttribute( "DojoList", DojoList );
			return "Ninja.jsp";	
		}	
	}
	
	@RequestMapping( value = "/createNinja", method = RequestMethod.POST )
	public String createNinja( @RequestParam( value = "dojo_id") long dojoId,
			@RequestParam( value = "first_name") String first_name,
			@RequestParam( value = "last_name") String last_name,
			@RequestParam( value = "age") int age ,Model model, RedirectAttributes redirectAttributes ) {
		if (first_name.equals(" ")) {
			redirectAttributes.addFlashAttribute("errorMessage", "Provide first name");
			return "redirect:/addNinja";
		}
		if (last_name.equals(" ")) {
			redirectAttributes.addFlashAttribute("errorMessage", "Provide last name");
			return "redirect:/addNinja";
		}
		else {
			Dojo selectedDojo = dojoService.getDojoById( dojoId);
			System.out.println(selectedDojo);
			Ninja newNinja = new Ninja (first_name, last_name, age,selectedDojo);
			ninjaService.createNinja(newNinja);
			return "redirect:/";
		}
		
	
	}
		
	@RequestMapping("/")
	public String dojoHome(Model model) {
		List<Dojo> DojoList = dojoService.getAllDojos();
		model.addAttribute( "DojoList", DojoList );
		return "home.jsp";
	}

}
