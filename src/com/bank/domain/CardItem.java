/**
 * 
 */
package com.bank.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Arnaud
 *
 */


@Entity
@Table (name = "CARDITEM")
public class CardItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeCardItem;
	private int quantite;
	private BigDecimal prixTotal;
	@JsonBackReference
	@ManyToOne
	@JoinColumn (name = "CODE_CARD")
	private Card card;
	@ManyToOne
	@JoinColumn (name = "CODE_PRODUCT")
	private Product product;
	
	public CardItem() {
		
	}
	
	public CardItem(Long codeCardItem) {
		super();
		this.codeCardItem = codeCardItem;
	}

	public Long getCodeCardItem() {
		return codeCardItem;
	}

	public void setCodeCardItem(Long codeCardItem) {
		this.codeCardItem = codeCardItem;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public BigDecimal getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(BigDecimal prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void updatePrixTotal() {
		prixTotal = this.product.getPrixUnitaire().multiply(new BigDecimal(this.quantite));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeCardItem == null) ? 0 : codeCardItem.hashCode());
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
		CardItem other = (CardItem) obj;
		if (codeCardItem == null) {
			if (other.codeCardItem != null)
				return false;
		} else if (!codeCardItem.equals(other.codeCardItem))
			return false;
		return true;
	}
}
