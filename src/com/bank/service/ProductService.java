/**
 * 
 */
package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.domain.Product;

/**
 * @author Arnaud
 *
 */

public interface ProductService {

	Product getProductByCodeProduit(Long codeProduit);
}
