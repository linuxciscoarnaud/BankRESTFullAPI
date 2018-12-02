/**
 * 
 */
package com.bank.domain.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.Card;
import com.bank.domain.CardItem;
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
		card.setCodeCard(cardDto.getCodeCardDto());
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
	public Card read(String codeCard) {
		// TODO Auto-generated method stub 
		Card card = entityManager.find(Card.class, codeCard);
		return card;
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.CardRepository#update(java.lang.Long, com.bank.dto.CardDto)
	 */
	@Override
	public void update(String codeCard, CardDto cardDto) {
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
	public void delete(String id) {
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
	public void addItem(String codeCard, String codeProduit) {
		// TODO Auto-generated method stub
		System.out.println("code cart: " + codeCard);
		Card card = null;
		Product product = productService.getProductByCodeProduit(codeProduit);
		
		card = read(codeCard);
		if(card == null) {     // The cart does not exists yet. So needs to be created.
			CardItemDto newCardItemDto = new CardItemDto();
			newCardItemDto.setCodeProduit(codeProduit);
			newCardItemDto.setQuantite(1);
			CardDto newCardDto = new CardDto(codeCard);
			newCardDto.addCardItem(newCardItemDto);
			create(newCardDto);
			return;
		}
		if (card.getItemByCodeProduit(codeProduit) == null) {  // The cart already exists, but the item we wish to add
			CardItem cardItem = new CardItem();                // does not yet exists on the cart. So we create a new
			cardItem.setQuantite(1);                           // cart item and add the item
			cardItem.setProduct(product);
        	cardItem.setCard(card);
        	entityManager.persist(cardItem);
		}
		else {                                                              // The cart already exists, the item we wish to add also.
			CardItem existingItem = card.getItemByCodeProduit(codeProduit); // So we  just update the existing cart item with one more
			existingItem.setProduct(product);                             // same item.
			existingItem.setCard(card);
			existingItem.setQuantite(existingItem.getQuantite() + 1);
			entityManager.merge(existingItem);
		}
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.CardRepository#removeItem(java.lang.String, java.lang.String)
	 */
	@Override
	public void removeItem(String codeCard, String codeProduit) {
		// TODO Auto-generated method stub
		Card card = read(codeCard);
		CardItem cardItem = card.getItemByCodeProduit(codeProduit);
		if(cardItem != null) {
			entityManager.remove(cardItem);
		}
	}
}
