/**
 * 
 */
package com.bank.domain.repository;

import com.bank.domain.Card;
import com.bank.dto.CardDto;

/**
 * @author Arnaud
 *
 */

public interface CardRepository {

	void create(CardDto cardDto);
	Card read(Long codeCard);
	void update(Long id, CardDto cardDto);
	void delete(Long id);
	void addItem(Long codeCard, Long codeProduit);
	void removeItem(Long codeCard, Long codeProduit);
}
