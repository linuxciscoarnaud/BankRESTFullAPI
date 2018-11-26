/**
 * 
 */
package com.bank.dto;

import java.io.Serializable;

/**
 * @author Arnaud
 *
 */


public class CardItemDto implements Serializable {

	private static final long serialVersionUID = -3551573319376880896L;
	
	private Long codeCardItemDto;
	private Long codeProduit;
	private int quantite;
	
	public Long getCodeCardItemDto() {
		return codeCardItemDto;
	}
	public void setCodeCardItemDto(Long codeCardItemDto) {
		this.codeCardItemDto = codeCardItemDto;
	}
	public Long getCodeProduit() {
		return codeProduit;
	}
	public void setCodeProduit(Long codeProduit) {
		this.codeProduit = codeProduit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
}
