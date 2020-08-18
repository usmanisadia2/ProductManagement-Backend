package com.cg.demo.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/******************************************
- File Name      : Product.java
- Author           : Capgemini
- Creation Date    : 13-08-2020
- Description      : This Entity class provides application-defined object to manage the entire ProductService
 ******************************************/

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "product_table")
@EntityListeners(AuditingEntityListener.class)
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productId;
	private double price;
	private String colour;
	private String dimension;
	private String specification;
	private String manufacture;
	private int quantity;
	private String productCategory;
	private String productName;
	private String productURL;
	
	public Product() {}

	public Product(long productId, double price, String colour, String dimension, String specification,
			String manufacture, int quantity, String productCategory, String productName, String productURL) {
		super();
		this.productId = productId;
		this.price = price;
		this.colour = colour;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacture = manufacture;
		this.quantity = quantity;
		this.productCategory = productCategory;
		this.productName = productName;
		this.productURL=productURL;
	}

	public String getProductURL() {
		return productURL;
	}

	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
	
	

}