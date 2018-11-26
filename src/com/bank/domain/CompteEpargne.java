/**
 * 
 */
package com.bank.domain;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Arnaud
 *
 */

@Entity
@DiscriminatorValue ("CE")
public class CompteEpargne extends Compte{

	private double taux;
	
	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompteEpargne(String codeCompte, Date dateCreation, double taux) {
		super(codeCompte, dateCreation);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}
