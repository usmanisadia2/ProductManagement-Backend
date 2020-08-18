package com.cg.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.demo.entity.Product;
import com.cg.demo.repository.ProductRepository;


/******************************************
- File Name      : ProductDao.java
- Author           : Capgemini
- Creation Date    : 13-08-2020
- Description      : This Dao class act as a class which is used to access data from database
 ******************************************/

@Repository
public class ProductDao{
@Autowired
private ProductRepository productRepository;

public Product addProduct(Product product) {
	return productRepository.save(product);
}

public List<Product> getProduct() {
	return productRepository.findAll();
}

public String deleteProduct(Product product) {
	productRepository.deleteById(product.getProductId());
	return "Product Deleted Successfully!";
}

public Optional<Product> findById(long id) {
	return productRepository.findById(id);
}

public Product save(Product product) {
	return productRepository.save(product);
}

public Product findOne(long Id) {
	return productRepository.findById(Id).get();
}
}