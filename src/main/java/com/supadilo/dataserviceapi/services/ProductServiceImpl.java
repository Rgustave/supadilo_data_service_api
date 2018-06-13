package com.supadilo.dataserviceapi.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.supadilo.dataserviceapi.entities.Product;
import com.supadilo.dataserviceapi.repositories.CategoryRepo;
import com.supadilo.dataserviceapi.repositories.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepo productRepo;

	@Autowired
	ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productList = verifyProductList();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Product> getOneProduct(Long productId) throws NoSuchElementException {
		Product product = verifyProduct(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Product> updateProduct(Product product) {
		Product updateProduct = productRepo.save(product);
		return new ResponseEntity<>(updateProduct, HttpStatus.OK);

	}

	@Override
	public void deleteProduct(Long productId) {
		Product product = verifyProduct(productId);
		productRepo.delete(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productRepo.delete(product);
	}
	
	/**
	 * Verify if a searched products List exist
	 * @return
	 * @throws NoSuchElementException
	 */

	private List<Product> verifyProductList() throws NoSuchElementException {
		List<Product> productList = productRepo.findAll();
		if (productList == null) {
			throw new NoSuchElementException("Product List does not exist ");
		}
		return productList;
	}

	
	
	/**
	 * Verify if the Product Exist
	 * @param productId
	 * @return
	 * @throws NoSuchElementException
	 */
	private Product verifyProduct(Long productId) throws NoSuchElementException {
		Product product = productRepo.findByProductID(productId);
		if (product == null) {
			throw new NoSuchElementException("Product does not exist " + productId);
		}
		return product;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ex) {
		return ex.getMessage();

	}

	public ResponseEntity<Product>  saveNewProduct(Product product) {
		Product savedProduct =	productRepo.save(product);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
}
