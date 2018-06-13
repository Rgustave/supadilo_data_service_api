package com.supadilo.dataserviceapi.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Product implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4606993924470885113L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productID;
	private String productName;
	private String location;
	private String price;
	private String status;
	private String description;
	private Date postTime;
	private String url;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;
	

}
