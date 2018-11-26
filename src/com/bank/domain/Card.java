/**
 * 
 */
package com.bank.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.function.Function;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Arnaud
 *
 */

@Entity
@Table (name = "CARD")
//@XmlRootElement
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeCard;
	private BigDecimal totalGeneral;
	@OneToMany (mappedBy = "card", fetch = FetchType.EAGER)
	private Collection<CardItem> cardItems;
	
	public Card() {
		
	}
	
	public Card(Long codeCard) {
		this.codeCard = codeCard;
	}

	public Long getCodeCard() {
		return codeCard;
	}

	public void setCodeCard(Long codeCard) {
		this.codeCard = codeCard;
	}

	public BigDecimal getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(BigDecimal totalGeneral) {
		this.totalGeneral = totalGeneral;
	}

	public Collection<CardItem> getCardItems() {
		return cardItems;
	}

	public void setCardItems(Collection<CardItem> cardItems) {
		this.cardItems = cardItems;
	}
	
	public CardItem getItemByCodeProduit(Long codeProduit) {
		return cardItems.stream().filter(cardItem -> cardItem.getProduct().getCodeProduit()
		         .equals(codeProduit))
		         .findAny()
		         .orElse(null);
	}
	
	public void updateTotalGeneral() {
		Function<CardItem, BigDecimal> totalMapper = cardItem -> cardItem.getPrixTotal();
		
		BigDecimal totalGeneral = cardItems.stream().map(totalMapper).reduce(BigDecimal.ZERO, BigDecimal::add);
		
		this.setTotalGeneral(totalGeneral);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeCard == null) ? 0 : codeCard.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (codeCard == null) {
			if (other.codeCard != null)
				return false;
		} else if (!codeCard.equals(other.codeCard))
			return false;
		return true;
	}
}
