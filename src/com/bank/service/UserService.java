/**
 * 
 */
package com.bank.service;

import java.util.List;

import com.bank.domain.Client;
import com.bank.domain.Compte;
import com.bank.domain.Employe;
import com.bank.domain.Groupe;
import com.bank.domain.Operation;

/**
 * @author Arnaud
 *
 */

public interface UserService {

	public Client addClient(Client client);
	public List<Client> consulterTousLesClients();
	public Employe addEmploye(Employe employe, String codeSup);
	public Groupe addGroupe(Groupe groupe);
	public void addEmployeToGroupe(String codeEmploye, String codeGroupe);
	public Client consulterClient(String codeClient);
	public List<Client> consulterClients(String motCle);
	public List<Employe> getEmployes();
	public List<Groupe> getGroupes();
	public List<Employe> getEmployesByGroupe(String codeGroupe);
}
