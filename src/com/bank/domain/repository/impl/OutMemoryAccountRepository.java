/**
 * 
 */
package com.bank.domain.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.Client;
import com.bank.domain.Compte;
import com.bank.domain.Employe;
import com.bank.domain.Operation;
import com.bank.domain.repository.AccountRepository;

/**
 * @author Arnaud
 *
 */

@Repository
@Transactional
public class OutMemoryAccountRepository implements AccountRepository {

	@PersistenceContext
	public EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.bank.domain.repository.AccountRepository#addCompte(com.bank.domain.Compte, java.lang.Long, java.lang.Long)
	 */
	@Override
	public Compte addCompte(Compte compte, String codeClient, String codeEmploye) {
		// TODO Auto-generated method stub
		Client client = entityManager.find(Client.class, codeClient);
		Employe employe = entityManager.find(Employe.class, codeEmploye);
		compte.setClient(client);
		compte.setEmploye(employe);
		entityManager.persist(compte);
		return compte;
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.AccountRepository#addOperation(com.bank.domain.Operation, java.lang.String, java.lang.Long)
	 */
	@Override
	public Operation addOperation(Operation operation, String codeCompte, String codeEmploye) {
		// TODO Auto-generated method stub
		Compte compte = consulterCompte(codeCompte);
		Employe employe = entityManager.find(Employe.class, codeEmploye);
		operation.setCompte(compte);
		operation.setEmploye(employe);
		entityManager.persist(operation);
		return operation;
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.AccountRepository#versement(java.lang.String, double, java.lang.Long)
	 */
	@Override
	public void versement(String codeCompte, double montant, String codeEmploye) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.AccountRepository#retrait(java.lang.String, double, java.lang.Long)
	 */
	@Override
	public void retrait(String codeCompte, double montant, String codeEmploye) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.AccountRepository#virement(java.lang.String, java.lang.String, double, java.lang.Long)
	 */
	@Override
	public void virement(String codeCompte1, String codeCompte2, double montant, String codeEmploye) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.AccountRepository#consulterCompte(java.lang.String)
	 */
	@Override
	public Compte consulterCompte(String codeCompte) {
		// TODO Auto-generated method stub
		Compte compte = entityManager.find(Compte.class, codeCompte);
		if (compte == null) {
			throw new RuntimeException("Compte Introuvable");
		}
		return compte;
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.AccountRepository#consulterOperations(java.lang.String)
	 */
	@Override
	public List<Operation> consulterOperations(String codeCompte) {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("select o from Operation o where o.compte.codeCompte = :x");
		req.setParameter("x", codeCompte);
		return req.getResultList();
	}
	
	public List<Compte> getComptesDuClient(String codeClient) {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("select cm from Compte cm where cm.client.codeClient = :x");
		req.setParameter("x", codeClient);
		return req.getResultList();
	}
	
	public List<Compte> getComptesParEmploye(String codeEmploye) {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("select cm from Compte cm where cm.employe.codeEmploye = :x");
		req.setParameter("x", codeEmploye);
		return req.getResultList();
	}

}
