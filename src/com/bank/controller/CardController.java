/**
 * 
 */
package com.bank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Arnaud
 *
 */

@Controller
@RequestMapping(value = "/card")
public class CardController {

	@RequestMapping
	public String get(HttpServletRequest request) {
		System.out.println("NOW HERE 1");
		return "redirect:/card/"+request.getSession(true).getId(); 
	}
	
	@RequestMapping(value = "/{cardId}", method = RequestMethod.GET)
	public String getCard(@PathVariable(value = "cardId") String cardId, Model model) {
		System.out.println("NOW HERE 2");
		model.addAttribute("cardId",cardId);
		return "card";
	}
	
}
