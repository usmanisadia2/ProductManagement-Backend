package com.cg.demo.service;
import java.util.List;
import com.cg.demo.entity.Product;

public interface ProductService {

	public Product addProduct(Product product) ;
	
	public List<Product> getProduct() ;
	
	public String deleteProduct(Product product) ;
	
	public Product findOne(long Id) ;
}