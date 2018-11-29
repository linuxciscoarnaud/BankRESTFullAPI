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

	public Compte addCompte(Compte compte, Long codeClient, Long codeEmploye);
	public Operation addOperation(Operation operation, String codeCompte, Long codeEmploye);
	public void versement(String codeCompte, double montant, Long codeEmploye);
	public void retrait(String codeCompte, double montant, Long codeEmploye);
	public void virement(String codeCompte1, String codeCompte2, double montant, Long codeEmploye);
	public Compte consulterCompte(String codeCompte);
	public List<Operation> consulterOperations(String codeCompte);
	public List<Compte> getComptesDuClient(Long codeClient);
	public List<Compte> getComptesParEmploye(Long codeEmploye);
}
