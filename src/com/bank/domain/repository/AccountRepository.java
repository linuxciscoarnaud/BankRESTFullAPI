/**
 * 
 */
package com.bank.domain.repository;

import java.util.List;

import com.bank.domain.Compte;
import com.bank.domain.Operation;

/**
 * @author Arnaud
 *
 */


public interface AccountRepository {

	public Compte addCompte(Compte compte, String codeClient, String codeEmploye);
	public Operation addOperation(Operation operation, String codeCompte, String codeEmploye);
	public void versement(String codeCompte, double montant, String codeEmploye);
	public void retrait(String codeCompte, double montant, String codeEmploye);
	public void virement(String codeCompte1, String codeCompte2, double montant, String codeEmploye);
	public Compte consulterCompte(String codeCompte);
	public List<Operation> consulterOperations(String codeCompte);
	public List<Compte> getComptesDuClient(String codeClient);
	public List<Compte> getComptesParEmploye(String codeEmploye);
}
