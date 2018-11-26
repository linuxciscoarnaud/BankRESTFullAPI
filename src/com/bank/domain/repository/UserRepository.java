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
	public Compte addCompte(Compte compte, Long codeClient, Long codeEmploye);
	public Operation addOperation(Operation operation, String codeCompte, Long codeEmploye);
	public void versement(String codeCompte, double montant, Long codeEmploye);
	public void retrait(String codeCompte, double montant, Long codeEmploye);
	public void virement(String codeCompte1, String codeCompte2, double montant, Long codeEmploye);
	public Compte consulterCompte(String codeCompte);
	public List<Operation> consulterOperations(String codeCompte);
	public Client consulterClient(Long codeClient);
	public List<Client> consulterClients(String motCle);
}
