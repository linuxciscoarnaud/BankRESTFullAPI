/**
 * 
 */
package com.bank.service;

import com.bank.domain.Card;
import com.bank.dto.CardDto;

/**
 * @author Arnaud
 *
 */

public interface CardService {

	void create(CardDto cardDto);
	Card read(String codeCard);
	void update(String id, CardDto cardDto);
	void delete(String id);
	void addItem(String codeCard, String codeProduit);
	void removeItem(String codeCard, String codeProduit);
}
