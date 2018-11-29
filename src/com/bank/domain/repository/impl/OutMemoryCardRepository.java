/**
 * 
 */
package com.bank.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.Card;
import com.bank.domain.CardItem;
import com.bank.domain.Operation;
import com.bank.domain.Product;
import com.bank.domain.repository.CardRepository;
import com.bank.dto.CardDto;
import com.bank.dto.CardItemDto;
import com.bank.service.ProductService;

/**
 * @author Arnaud
 *
 */

@Repository
@Transactional
public class OutMemoryCardRepository implements CardRepository {

	@PersistenceContext
	public EntityManager entityManager;
	
	@Autowired
	private ProductService productService;
	
	/* (non-Javadoc)
	 * @see com.bank.domain.repository.CardRepository#create(com.bank.dto.CardDto)
	 * This method creates a shopping cart
	 */
	@Override
	public void create(CardDto cardDto) {
		// TODO Auto-generated method stub
		Card card = new Card();
		card.setTotalGeneral(cardDto.getTotalGeneral());
        entityManager.persist(card);
        cardDto.getCardItems().stream().forEach(cardItemDto -> {
        	Product product = productService.getProductByCodeProduit(cardItemDto.getCodeProduit());
        	CardItem cardItem = new CardItem();
        	cardItem.setProduct(product);
        	cardItem.setCard(card);
        	cardItem.setQuantite(cardItemDto.getQuantite());
        	cardItem.setPrixTotal(cardItemDto.getPrixTotal());
        	entityManager.persist(cardItem); 
        });
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.CardRepository#read(java.lang.Long)
	 */
	@Override
	public Card read(Long codeCard) {
		// TODO Auto-generated method stub 
		//List<CardItem> cardItems;
		Card card = entityManager.find(Card.class, codeCard);
		if (card == null) {
			throw new RuntimeException("Card not found");
		}
		//else {
			//Query req = entityManager.createQuery("select ci from CardItem ci where ci.card.codeCard = :x");
			//req.setParameter("x", codeCard);
			//cardItems = new ArrayList<>();
			//cardItems = req.getResultList();
			//card.setCardItems(cardItems);
		//}
		return card;
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.CardRepository#update(java.lang.Long, com.bank.dto.CardDto)
	 */
	@Override
	public void update(Long codeCard, CardDto cardDto) {
		// TODO Auto-generated method stub
		Card card = entityManager.find(Card.class, codeCard);		
		List<CardItemDto> cardItemsDto = cardDto.getCardItems();
		for(CardItemDto cardItemDto :cardItemsDto) {
			Product product = productService.getProductByCodeProduit(cardItemDto.getCodeProduit());
			Query req = entityManager.createQuery("select ci from CardItem ci where ci.codeCardItem = :y and ci.card.codeCard = :x");
			req.setParameter("y", cardItemDto.getCodeCardItemDto());
			req.setParameter("x", codeCard);
			List<CardItem> cardItems = req.getResultList();
			if (cardItems != null) {
				CardItem cardItem = cardItems.get(0);
				cardItem.setQuantite(cardItemDto.getQuantite());
				cardItem.setCard(card);
				cardItem.setProduct(product);
				entityManager.merge(cardItem);
			}		
		}
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.CardRepository#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("select ci from CardItem ci where ci.card.codeCard = :x");
		req.setParameter("x", id);
		List<CardItem> cardItems = req.getResultList();
		if (cardItems != null) {
			for (CardItem cardItem : cardItems) {
				entityManager.remove(cardItem);
			}	
		}	
		Card card = entityManager.find(Card.class, id);
		entityManager.remove(card);
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.CardRepository#addItem(java.lang.Long, java.lang.Long)
	 */
	@Override
	public void addItem(Long codeCard, Long codeProduit) {
		// TODO Auto-generated method stub
		Card card = null;
		Product product = productService.getProductByCodeProduit(codeProduit);
		
		card = read(codeCard);
		if(card == null) {
			CardItemDto newCardItemDto = new CardItemDto();
			newCardItemDto.setCodeCardItemDto(codeProduit);
			newCardItemDto.setQuantite(1);
			CardDto newCardDto = new CardDto(codeCard);
			newCardDto.addCardItem(newCardItemDto);
			create(newCardDto);
			return;
		}
		if (card.getItemByCodeProduit(codeProduit) == null) {
			CardItem cardItem = new CardItem();
			cardItem.setQuantite(1);
			cardItem.setProduct(product);
        	cardItem.setCard(card);
        	entityManager.persist(cardItem);
		}
		else {
			CardItem existingItem = card.getItemByCodeProduit(codeProduit);
			//existingItem.setProduct(product);
			existingItem.setCard(card);
			existingItem.setQuantite(existingItem.getQuantite() + 1);
			entityManager.merge(existingItem);
		}
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.CardRepository#removeItem(java.lang.String, java.lang.String)
	 */
	@Override
	public void removeItem(Long codeCard, Long codeProduit) {
		// TODO Auto-generated method stub
		Card card = read(codeCard);
		CardItem cardItem = card.getItemByCodeProduit(codeProduit);
		if(cardItem != null) {
			entityManager.remove(cardItem);
		}
	}
}
