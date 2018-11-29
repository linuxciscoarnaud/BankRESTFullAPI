/**
 * 
 */
package com.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.Compte;
import com.bank.domain.Operation;
import com.bank.domain.repository.AccountRepository;
import com.bank.service.AccountService;

/**
 * @author Arnaud
 *
 */

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	/* (non-Javadoc)
	 * @see com.bank.service.AccountService#addCompte(com.bank.domain.Compte, java.lang.Long, java.lang.Long)
	 */
	@Override
	public Compte addCompte(Compte compte, Long codeClient, Long codeEmploye) {
		// TODO Auto-generated method stub
		return accountRepository.addCompte(compte, codeClient, codeEmploye);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.AccountService#addOperation(com.bank.domain.Operation, java.lang.String, java.lang.Long)
	 */
	@Override
	public Operation addOperation(Operation operation, String codeCompte, Long codeEmploye) {
		// TODO Auto-generated method stub
		return accountRepository.addOperation(operation, codeCompte, codeEmploye);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.AccountService#versement(java.lang.String, double, java.lang.Long)
	 */
	@Override
	public void versement(String codeCompte, double montant, Long codeEmploye) {
		// TODO Auto-generated method stub
		accountRepository.versement(codeCompte, montant, codeEmploye);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.AccountService#retrait(java.lang.String, double, java.lang.Long)
	 */
	@Override
	public void retrait(String codeCompte, double montant, Long codeEmploye) {
		// TODO Auto-generated method stub
		accountRepository.retrait(codeCompte, montant, codeEmploye);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.AccountService#virement(java.lang.String, java.lang.String, double, java.lang.Long)
	 */
	@Override
	public void virement(String codeCompte1, String codeCompte2, double montant, Long codeEmploye) {
		// TODO Auto-generated method stub
		accountRepository.virement(codeCompte1, codeCompte2, montant, codeEmploye);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.AccountService#consulterCompte(java.lang.String)
	 */
	@Override
	public Compte consulterCompte(String codeCompte) {
		// TODO Auto-generated method stub
		return accountRepository.consulterCompte(codeCompte);
	}

	/* (non-Javadoc)
	 * @see com.bank.service.AccountService#consulterOperations(java.lang.String)
	 */
	@Override
	public List<Operation> consulterOperations(String codeCompte) {
		// TODO Auto-generated method stub
		return accountRepository.consulterOperations(codeCompte);
	}

	@Override
	public List<Compte> getComptesDuClient(Long codeClient) {
		// TODO Auto-generated method stub
		return accountRepository.getComptesDuClient(codeClient);
	}
	
	@Override
	public List<Compte> getComptesParEmploye(Long codeEmploye) {
		// TODO Auto-generated method stub
		return accountRepository.getComptesParEmploye(codeEmploye);
	}
}
