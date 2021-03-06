/**
 * 
 */
package com.bank.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.bank.tools.IdGenerator;

/**
 * @author Arnaud
 *
 */

@Entity
@Table (name = "CLIENT")
public class Client implements Serializable {
	
	@Id
	@GeneratedValue(generator = IdGenerator.generatorName)
	@GenericGenerator(name = IdGenerator.generatorName, strategy = "com.bank.tools.IdGenerator")
	private String codeClient;
	private String nomClient;
	private String adresseClient;
	@OneToMany (mappedBy = "client", fetch = FetchType.LAZY)
	private Collection<Compte> comptes;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(String nomClient, String adresseClient) {
		super();
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
	}
	
	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
}
