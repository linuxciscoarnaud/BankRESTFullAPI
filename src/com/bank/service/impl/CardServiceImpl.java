/**
 * 
 */
package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.domain.Card;
import com.bank.domain.repository.CardRepository;
import com.bank.dto.CardDto;
import com.bank.service.CardService;

/**
 * @author Arnaud
 *
 */

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardRepository cardRepository;
	
	/* (non-Javadoc)
	 * @see com.bank.service.CardService#create(com.bank.dto.CardDto)
	 */
	@Override
	public void create(CardDto cardDto) {
		// TODO Auto-generated method stub
		cardRepository.create(cardDto);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.CardService#read(java.lang.Long)
	 */
	@Override
	public Card read(String codeCard) {
		// TODO Auto-generated method stub
		return cardRepository.read(codeCard);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.CardService#update(java.lang.Long, com.bank.dto.CardDto)
	 */
	@Override
	public void update(String id, CardDto cardDto) {
		// TODO Auto-generated method stub
		cardRepository.update(id, cardDto);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.CardService#delete(java.lang.Long)
	 */
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		cardRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.CardService#addItem(java.lang.Long, java.lang.Long)
	 */
	@Override
	public void addItem(String codeCard, String codeProduit) {
		// TODO Auto-generated method stub
		cardRepository.addItem(codeCard, codeProduit);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.CardService#removeItem(java.lang.Long, java.lang.Long)
	 */
	@Override
	public void removeItem(String codeCard, String codeProduit) {
		// TODO Auto-generated method stub
		cardRepository.removeItem(codeCard, codeProduit);
	}
}
