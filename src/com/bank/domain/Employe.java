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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.bank.tools.IdGenerator;

/**
 * @author Arnaud
 *
 */

@Entity
public class Employe implements Serializable {

	@Id
	@GeneratedValue(generator = IdGenerator.generatorName)
	@GenericGenerator(name = IdGenerator.generatorName, strategy = "com.bank.tools.IdGenerator")
	private String codeEmploye;
	private String nomEmploye;
	@ManyToOne
	@JoinColumn (name = "CODE_EMPLOYE_SUP")
	private Employe employeSup;
	@ManyToMany
	@JoinTable (name = "EMPLOYE_GROUPE", joinColumns = 
	@JoinColumn (name = "CODE_EMPLOYE"),
	inverseJoinColumns = @JoinColumn (name = "CODE_GROUPE"))
	private Collection<Groupe> groupes;
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}



	public String getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(String codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	public Employe getEmployeSup() {
		return employeSup;
	}
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	
}
