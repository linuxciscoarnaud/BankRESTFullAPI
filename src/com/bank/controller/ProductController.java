/**
 * 
 */
package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.service.ProductService;

/**
 * @author Arnaud
 *
 */

@Controller
@RequestMapping("market")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String products(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/product")
	public String getProductByCodeProduct(@RequestParam("id") String codeProduit, Model model) {
		model.addAttribute("product", productService.getProductByCodeProduit(codeProduit));
		return "product";
	}
}
