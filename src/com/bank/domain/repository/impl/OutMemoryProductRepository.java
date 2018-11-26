/**
 * 
 */
package com.bank.domain.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bank.domain.Compte;
import com.bank.domain.Product;
import com.bank.domain.repository.ProductRepository;

/**
 * @author Arnaud
 *
 */

@Repository
public class OutMemoryProductRepository implements ProductRepository {

	@PersistenceContext
	public EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.bank.domain.repository.ProductRepository#getProductByCodeProduit(java.lang.Long)
	 */
	@Override
	public Product getProductByCodeProduit(Long codeProduit) {
		// TODO Auto-generated method stub
		Product product = entityManager.find(Product.class, codeProduit);
		if (product == null) {
			throw new RuntimeException("Product not found");
		}
		return product;
	}

}
