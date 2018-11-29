/**
 * 
 */
package com.bank.domain.repository;

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

public interface UserRepository {

	public Client addClient(Client client);
	public List<Client> consulterTousLesClients();
	public Employe addEmploye(Employe employe, Long codeSup);
	public Groupe addGroupe(Groupe groupe);
	public void addEmployeToGroupe(Long codeEmploye, Long codeGroupe);
	public Client consulterClient(Long codeClient);
	public List<Client> consulterClients(String motCle);
	public List<Employe> getEmployes();
	public List<Groupe> getGroupes();
	public List<Employe> getEmployesByGroupe(Long codeGroupe);
}
