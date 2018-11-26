/**
 * 
 */
package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.domain.Client;
import com.bank.service.UserService;

/**
 * @author Arnaud
 *
 */

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/clients")
	public String clients(Model model) {
		
		model.addAttribute("clients", userService.consulterTousLesClients());
		
		return "clients";
	}
	
	@RequestMapping(value = "/clients/add", method = RequestMethod.GET)
	public String getAddNewClientForm(Model model) {
		Client newClient = new Client();
		model.addAttribute("newClient", newClient);
		
		return "addClient";
	}
	
	@RequestMapping(value = "/clients/add", method = RequestMethod.POST)
	public String processAddNewClientForm(@ModelAttribute("newClient")Client newClient) {
		userService.addClient(newClient);
		return "redirect:/user/clients";
	}
	
}
