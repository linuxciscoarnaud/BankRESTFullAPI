/**
 * 
 */
package com.bank.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import com.bank.tools.IdGenerator;

/**
 * @author Arnaud
 *
 */

@Entity
public class Groupe implements Serializable {

	@Id
	@GeneratedValue(generator = IdGenerator.generatorName)
	@GenericGenerator(name = IdGenerator.generatorName, strategy = "com.bank.tools.IdGenerator")
	private String codeGroupe;
	private String nomGroupe;
	@ManyToMany (mappedBy = "groupes")
	private Collection<Employe> employes;
	
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}



	public String getCodeGroupe() {
		return codeGroupe;
	}
	public void setCodeGroupe(String codeGroupe) {
		this.codeGroupe = codeGroupe;
	}
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	public Collection<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
	
	
}
