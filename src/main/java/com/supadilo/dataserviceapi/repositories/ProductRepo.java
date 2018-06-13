package com.supadilo.dataserviceapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supadilo.dataserviceapi.entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
	
	/**
	 * get all Product List Available 
	 * @return
	 */
	List<Product> findAll();
	
	/*
	 * get one Product given productId
	 * @return Product
	 */
	///Product findByProductId(Long productId);
	Product findByProductID(Long productId);
	
	
	
	

}
