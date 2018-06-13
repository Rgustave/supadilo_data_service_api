package com.supadilo.dataserviceapi.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.supadilo.dataserviceapi.entities.Product;
import com.supadilo.dataserviceapi.services.ProductServiceImpl;

@RestController
@RequestMapping(value ="/v1")
public class ProductController {
	

	@Autowired
	private ProductServiceImpl productService;
	
	
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>>getAllProducts(){
		return  productService.getAllProducts();
	}
	
	
	@PutMapping("/products")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Product>updateProduct(@RequestBody Product product){
		  return productService.updateProduct(product);
	}
	
	
	@GetMapping("/products/{productID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Product> getOneProduct(@PathVariable(value = "productID")  Long productID){
		  return productService.getOneProduct(productID);
	}
	
	@DeleteMapping("/products")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@RequestBody Product product){
		  productService.deleteProduct(product);
	}
	
	
	@DeleteMapping("/products/{productID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@PathVariable(value = "productID")  Long productID){
		  productService.deleteProduct(productID);
	}
	
	@PostMapping("/products")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return productService.saveNewProduct(product);
		
	}
	
	
	
}
