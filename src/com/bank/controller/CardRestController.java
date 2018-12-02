/**
 * 
 */
package com.bank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bank.domain.Card;
import com.bank.dto.CardDto;
import com.bank.service.CardService;
import com.bank.tools.Tools;

/**
 * @author Arnaud
 *
 */

@RestController
@RequestMapping(value = "rest/card")
public class CardRestController {

	@Autowired
	private CardService cardService;
	
	Tools tools = new Tools();
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void create(@RequestBody CardDto cardDto) {
		cardService.create(cardDto);
	}
	
	@RequestMapping(value = "/{cardId}", method = RequestMethod.GET)
	public Card read(@PathVariable(value = "cardId") String cardId) {
		return cardService.read(cardId);
	}
	
	@RequestMapping(value = "/{cardId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void update(@PathVariable(value = "cardId") String cardId, @RequestBody CardDto cardDto) {
		cardDto.setCodeCardDto(cardId);
		cardService.update(cardId, cardDto);
	}
	
	@RequestMapping(value = "/{cardId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(value = "cardId") String cardId) {
		cardService.delete(cardId);
	}
	
	@RequestMapping(value = "/add/{codeProduit}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void addItem(@PathVariable String codeProduit, HttpSession session) {
		//System.out.println(session.getId());
		//System.out.println(tools.getSessionIdAsDigits(session.getId()));
		cardService.addItem(session.getId(), codeProduit);
	}
	
	@RequestMapping(value = "/remove/{codeProduit}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void removeItem(@PathVariable String codeProduit, HttpSession session) {
		cardService.removeItem(session.getId() ,codeProduit);
	}
}
