/**
 * 
 */
package com.bank.service;

import java.util.List;

import com.bank.domain.Product;

/**
 * @author Arnaud
 *
 */

public interface ProductService {

	Product getProductByCodeProduit(String codeProduit);
	List<Product> getAllProducts();
}
