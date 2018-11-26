/**
 * 
 */
package com.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.Client;
import com.bank.domain.Compte;
import com.bank.domain.Employe;
import com.bank.domain.Groupe;
import com.bank.domain.Operation;
import com.bank.domain.repository.UserRepository;
import com.bank.service.UserService;

/**
 * @author Arnaud
 *
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#addClient(com.bank.domain.Client)
	 */
	@Override
	public Client addClient(Client client) {
		// TODO Auto-generated method stub
		return userRepository.addClient(client);
	}
	
	public List<Client> consulterTousLesClients() {
		return userRepository.consulterTousLesClients();
	}

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#addEmploye(com.bank.domain.Employe, java.lang.Long)
	 */
	@Override
	public Employe addEmploye(Employe employe, Long codeSup) {
		// TODO Auto-generated method stub
		return userRepository.addEmploye(employe, codeSup);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#addGroupe(com.bank.domain.Groupe)
	 */
	@Override
	public Groupe addGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		return userRepository.addGroupe(groupe);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#addEmployeToGroupe(java.lang.Long, java.lang.Long)
	 */
	@Override
	public void addEmployeToGroupe(Long codeEmploye, Long codeGroupe) {
		// TODO Auto-generated method stub
		userRepository.addEmployeToGroupe(codeEmploye, codeGroupe);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#addCompte(com.bank.domain.Compte, java.lang.Long, java.lang.Long)
	 */
	@Override
	public Compte addCompte(Compte compte, Long codeClient, Long codeEmploye) {
		// TODO Auto-generated method stub
		return userRepository.addCompte(compte, codeClient, codeEmploye);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#addOperation(com.bank.domain.Operation, java.lang.String, java.lang.Long)
	 */
	@Override
	public Operation addOperation(Operation operation, String codeCompte, Long codeEmploye) {
		// TODO Auto-generated method stub
		return userRepository.addOperation(operation, codeCompte, codeEmploye);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#versement(java.lang.String, double, java.lang.Long)
	 */
	@Override
	public void versement(String codeCompte, double montant, Long codeEmploye) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#retrait(java.lang.String, double, java.lang.Long)
	 */
	@Override
	public void retrait(String codeCompte, double montant, Long codeEmploye) {
		// TODO Auto-generated method stub
		userRepository.retrait(codeCompte, montant, codeEmploye);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#virement(java.lang.String, java.lang.String, double, java.lang.Long)
	 */
	@Override
	public void virement(String codeCompte1, String codeCompte2, double montant, Long codeEmploye) {
		// TODO Auto-generated method stub
		userRepository.virement(codeCompte1, codeCompte2, montant, codeEmploye);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#consulterCompte(java.lang.String)
	 */
	@Override
	public Compte consulterCompte(String codeCompte) {
		// TODO Auto-generated method stub
		return userRepository.consulterCompte(codeCompte);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#consulterOperations(java.lang.String)
	 */
	@Override
	public List<Operation> consulterOperations(String codeCompte) {
		// TODO Auto-generated method stub
		return userRepository.consulterOperations(codeCompte);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#consulterClient(java.lang.Long)
	 */
	@Override
	public Client consulterClient(Long codeClient) {
		// TODO Auto-generated method stub
		return userRepository.consulterClient(codeClient);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#consulterClients(java.lang.String)
	 */
	@Override
	public List<Client> consulterClients(String motCle) {
		// TODO Auto-generated method stub
		return userRepository.consulterClients(motCle);
	}

}
