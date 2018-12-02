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
	public Employe addEmploye(Employe employe, String codeSup) {
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
	public void addEmployeToGroupe(String codeEmploye, String codeGroupe) {
		// TODO Auto-generated method stub
		userRepository.addEmployeToGroupe(codeEmploye, codeGroupe);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.UserService#consulterClient(java.lang.Long)
	 */
	@Override
	public Client consulterClient(String codeClient) {
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

	@Override
	public List<Employe> getEmployes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Groupe> getGroupes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Employe> getEmployesByGroupe(String codeGroupe) {
		// TODO Auto-generated method stub
		return null;
	}
}
