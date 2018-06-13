package com.supadilo.dataserviceapi.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.supadilo.dataserviceapi.entities.Product;

public interface ProductService {
	
	/**
	 * Get all  products available
	 * @return
	 */
	ResponseEntity<List<Product>>getAllProducts();
	/**
	 * Get a specific product
	 * @param ProductId
	 * @return
	 */
	ResponseEntity<Product>getOneProduct(Long ProductId);
	
	/**
	 * Update a specific product
	 * @param product
	 * @return
	 */
	ResponseEntity<Product>updateProduct(Product product);
	
	/**
	 * Delete Product given the productId
	 * @param ProductId
	 */
    void deleteProduct(Long ProductId);
    
    /**
     * Delete Product given the product
     * @param product
     */
    void deleteProduct(Product product);
    
    
    /**
     * Save a new Product
     * @param product
     * @return
     */
    public ResponseEntity<Product>  saveNewProduct(Product product);
}
