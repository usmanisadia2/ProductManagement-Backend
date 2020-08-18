package com.cg.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.demo.dao.ProductDao;
import com.cg.demo.entity.Product;
import com.cg.demo.exception.ProductNotFound;

/******************************************
- File Name        : ProductServiceImp.java
- Author           : Capgemini
- Creation Date    : 13-08-2020
- Description      : This Service class act as a class where Business logic is written
 ******************************************/

@Service
@Transactional
public class ProductServiceImp implements ProductService{

	@Autowired
	private ProductDao productDao ;
	
	@Override
	public Product addProduct(Product product) {
		return productDao.save(product) ;
	}

	@Override
	public List<Product> getProduct() {
		return productDao.getProduct() ;
	}

	@Override
	public String deleteProduct(Product product) {
		Optional<Product> p = productDao.findById(product.getProductId()) ;
		if(!p.isPresent()) {
			throw new ProductNotFound("Product Not Found!") ;
		}
		return productDao.deleteProduct(product) ;
	}

	@Override
	public Product findOne(long Id) {
		return productDao.findOne(Id) ;
	}

}
