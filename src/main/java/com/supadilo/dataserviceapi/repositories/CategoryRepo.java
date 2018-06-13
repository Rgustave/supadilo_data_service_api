package com.supadilo.dataserviceapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supadilo.dataserviceapi.entities.Product;

@Repository
public interface CategoryRepo extends JpaRepository<Product, Long>{

}
