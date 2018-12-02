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

import org.hibernate.annotations.GenericGenerator;

import com.bank.tools.IdGenerator;

/**
 * @author Arnaud
 *
 */

@Entity
@Table (name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(generator = IdGenerator.generatorName)
	@GenericGenerator(name = IdGenerator.generatorName, strategy = "com.bank.tools.IdGenerator")
	private String codeProduit;
	private String nomProduit;
	private BigDecimal prixUnitaire;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String codeProduit, String nomProduit, BigDecimal prixUnitaire) {
		this.codeProduit = codeProduit;
		this.nomProduit = nomProduit;
		this.prixUnitaire = prixUnitaire;
	}
	
	public String getCodeProduit() {
		return codeProduit;
	}
	public void setCodeProduit(String codeProduit) {
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
