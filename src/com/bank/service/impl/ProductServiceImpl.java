/**
 * 
 */
package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.domain.Product;
import com.bank.domain.repository.ProductRepository;
import com.bank.service.ProductService;

/**
 * @author Arnaud
 *
 */

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	/* (non-Javadoc)
	 * @see com.bank.service.ProductService#getProductByCodeProduit(java.lang.Long)
	 */
	@Override
	public Product getProductByCodeProduit(Long codeProduit) {
		// TODO Auto-generated method stub
		return productRepository.getProductByCodeProduit(codeProduit);
	}
}
