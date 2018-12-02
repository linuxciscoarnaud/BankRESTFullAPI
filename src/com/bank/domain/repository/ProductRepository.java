/**
 * 
 */
package com.bank.domain.repository;

import java.util.List;

import com.bank.domain.Product;

/**
 * @author Arnaud
 *
 */


public interface ProductRepository {

	Product getProductByCodeProduit(String codeProduit);
	List<Product> getAllProducts();
}
