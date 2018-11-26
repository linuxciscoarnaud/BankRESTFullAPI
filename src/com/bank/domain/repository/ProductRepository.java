/**
 * 
 */
package com.bank.domain.repository;

import com.bank.domain.Product;

/**
 * @author Arnaud
 *
 */


public interface ProductRepository {

	Product getProductByCodeProduit(Long codeProduit);
}
