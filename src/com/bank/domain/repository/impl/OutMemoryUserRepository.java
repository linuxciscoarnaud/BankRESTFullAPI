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
import com.bank.domain.Groupe;
import com.bank.domain.Operation;
import com.bank.domain.repository.UserRepository;

/**
 * @author Arnaud
 *
 */

@Repository
@Transactional
public class OutMemoryUserRepository implements UserRepository {

	@PersistenceContext
	public EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.bank.domain.repository.UserRepository#addClient(com.bank.domain.Client)
	 */
	@Override
	public Client addClient(Client client) {
		// TODO Auto-generated method stub
		entityManager.persist(client);
		return client;
	}
	
	public List<Client> consulterTousLesClients() {
		Query req = entityManager.createQuery("from Client c");
		return req.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.UserRepository#addEmploye(com.bank.domain.Employe, java.lang.Long)
	 */
	@Override
	public Employe addEmploye(Employe employe, Long codeSup) {
		// TODO Auto-generated method stub
		if (codeSup != null) {
			Employe employeSup = entityManager.find(Employe.class, codeSup);
			employe.setEmployeSup(employeSup);
		}
		entityManager.persist(employe);
		return employe;
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.UserRepository#addGroupe(com.bank.domain.Groupe)
	 */
	@Override
	public Groupe addGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		entityManager.persist(groupe);
		return groupe;
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.UserRepository#addEmployeToGroupe(java.lang.Long, java.lang.Long)
	 */
	@Override
	public void addEmployeToGroupe(Long codeEmploye, Long codeGroupe) {
		// TODO Auto-generated method stub
		Employe employe = entityManager.find(Employe.class, codeEmploye);
		Groupe groupe = entityManager.find(Groupe.class, codeGroupe);
		employe.getGroupes().add(groupe);
		groupe.getEmployes().add(employe);
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.UserRepository#consulterClient(java.lang.Long)
	 */
	@Override
	public Client consulterClient(Long codeClient) {
		// TODO Auto-generated method stub
		Client client = entityManager.find(Client.class, codeClient);
		if (client == null) {
			throw new RuntimeException("Client Introuvable");
		}
		return client;
	}

	/* (non-Javadoc)
	 * @see com.bank.domain.repository.UserRepository#consulterClients(java.lang.String)
	 */
	@Override
	public List<Client> consulterClients(String motCle) {
		Query req = entityManager.createQuery("select c from Client c where c.nomClient like: x");
		req.setParameter("x", "%" + motCle + "%");
		return req.getResultList();
	}
	
	@Override
	public List<Employe> getEmployes() {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("select e from Employe e");
		return req.getResultList();
	}
	
	@Override
	public List<Groupe> getGroupes() {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("select gr from Groupe gr");
		return req.getResultList();
	}
	
	public List<Employe> getEmployesByGroupe(Long codeGroupe) {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("select e Employe e where e.groupes.codeGroupe =: x");
		req.setParameter("x", codeGroupe);
		return req.getResultList();
	}
}
