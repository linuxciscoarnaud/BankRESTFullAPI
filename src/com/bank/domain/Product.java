/**
 * 
 */
package com.bank.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Arnaud
 *
 */

@Entity
@Table (name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeProduit;
	private String nomProduit;
	private BigDecimal prixUnitaire;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(Long codeProduit, String nomProduit, BigDecimal prixUnitaire) {
		this.codeProduit = codeProduit;
		this.nomProduit = nomProduit;
		this.prixUnitaire = prixUnitaire;
	}
	
	public Long getCodeProduit() {
		return codeProduit;
	}
	public void setCodeProduit(Long codeProduit) {
		this.codeProduit = codeProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
}
