/**
 * 
 */
package com.bank.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Arnaud
 *
 */


public class CardDto implements Serializable {

	private static final long serialVersionUID = - 2017182726290898588L;
	
	private String codeCardDto;
	private BigDecimal totalGeneral;
	
	private List<CardItemDto> cardItems;
	
	public BigDecimal getTotalGeneral() {
		return totalGeneral;
	}

	public CardDto() {}
	
	public CardDto(String codeCardDto) {
		this.codeCardDto = codeCardDto;
		cardItems = new ArrayList<>();
	}
	
	public void setTotalGeneral(BigDecimal totalGeneral) {
		this.totalGeneral = totalGeneral;
	}
	

	public String getCodeCardDto() {
		return codeCardDto;
	}

	public void setCodeCardDto(String codeCardDto) {
		this.codeCardDto = codeCardDto;
	}

	public List<CardItemDto> getCardItems() {
		return cardItems;
	}

	public void setCardItems(List<CardItemDto> cardItems) {
		this.cardItems = cardItems;
	}
	
	public void addCardItem(CardItemDto cardItemDto) {
		this.cardItems.add(cardItemDto);
	}
}
