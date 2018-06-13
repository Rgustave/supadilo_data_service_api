package com.supadilo.dataserviceapi.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Category  implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4519486134853934098L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  categoryId;
	private String categoryName;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // owner of the relationship.
	private Set<Product> productList;

}
