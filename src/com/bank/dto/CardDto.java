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
	
	private Long codeCardDto;
	private BigDecimal totalGeneral;
	
	public BigDecimal getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(BigDecimal totalGeneral) {
		this.totalGeneral = totalGeneral;
	}

	private List<CardItemDto> cardItems;
	
	public CardDto() {}
	
	public CardDto(Long codeCardDto) {
		this.codeCardDto = codeCardDto;
		cardItems = new ArrayList<>();
	}

	public Long getCodeCardDto() {
		return codeCardDto;
	}

	public void setCodeCardDto(Long codeCardDto) {
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
