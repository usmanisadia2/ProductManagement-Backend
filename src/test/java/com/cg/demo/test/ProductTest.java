package com.cg.demo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cg.demo.entity.Product;

@SpringBootTest
public class ProductTest {
	RestTemplate rst;
	
	@BeforeEach
	public void setup() {
		rst=new RestTemplate();
	}
	@Test
	public void addProduct() {
		Product product=new Product();
		
		product.setProductName("ABC1");
		product.setColour("Brown");
		product.setDimension("300x400");
		product.setManufacture("Amazon");
		product.setPrice(1000);
		product.setQuantity(20);
		product.setSpecification("very good product");
		product.setProductCategory("Golf");
		product.setProductURL("wertyuiosdfghjk");
		
		ResponseEntity<Product> p=rst.postForEntity("http://localhost:9090/product/addProduct", product, Product.class);
		Assertions.assertEquals(200, p.getStatusCodeValue());
	}
	
	@Test
	public void allProduct() {
		Product product=new Product();
		
		ResponseEntity<Product> p=rst.getForEntity("http://localhost:9090/product/allProduct", Product.class);
		Assertions.assertEquals(200, p.getStatusCodeValue());
		}
	
	@Test
	public void deleteProduct() {
		Product product=new Product();
		product.setProductId(6);
		
		rst.delete("http://localhost:9090/product/delete/6", product);
		
		
	}

}
