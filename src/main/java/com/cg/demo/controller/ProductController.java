package com.cg.demo.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.demo.entity.Product;
import com.cg.demo.entity.Response;
import com.cg.demo.service.ProductService;


/******************************************
- File Name      : ProductController.java
- Author           : Capgemini
- Creation Date    : 13-08-2020
- Description      : This Controller class act as an end point to manage the entire ProductService
 ******************************************/


@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService ;
	

	/******************************************
    - Method Name      : allProduct
    - Input Parameters : NA 
    - Return type      : boolean
    - End Point Url    : /allProduct
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 13-08-2020
    - Description      : Displaying the product information entered by admin   into  the database.
     ******************************************/
	
	@GetMapping("/allProduct")
	public ResponseEntity<Response> getAllProduct(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(productService.getProduct(), new Date()));
	}
	
	/******************************************
    - Method Name      : addProduct
    - Input Parameters : Product entity 
    - Return type      : boolean
    - End Point Url    : /addProduct
    -Request Method Type: PostMapping
    - Author           : Capgemini
    - Creation Date    : 13-08-2020
    - Description      : Inserting the product information entered by admin   into  the database.
     ******************************************/
	
	@PostMapping("/addProduct")
	public ResponseEntity<Response> createProduct(@Valid @RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(productService.addProduct(product), new Date()));
	}
	
	/******************************************
    - Method Name      : deleteProduct
    - Input Parameters : ProductId 
    - Return type      : boolean
    - End Point Url    : /delete/{id}
    -Request Method Type: DeleteMapping
    - Author           : Capgemini
    - Creation Date    : 14-08-2020
    - Description      : Deleting the product information entered by admin   into  the database.
     ******************************************/
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value= "Id") long Id){
		Product theProduct = productService.findOne(Id);
		if(theProduct == null) {
			return ResponseEntity.notFound().build();
		}
		productService.deleteProduct(theProduct);
		return ResponseEntity.ok().build();
	}
	
	/******************************************
    - Method Name      : updateProduct
    - Input Parameters : ProductId 
    - Return type      : boolean
    - End Point Url    : /update/{id}
    -Request Method Type: PutMapping
    - Author           : Capgemini
    - Creation Date    : 14-08-2020
    - Description      : Updating the product information entered by admin   into  the database.
     ******************************************/
	
	@PutMapping("/update/{ID}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value="ID") long ID,@Valid @RequestBody Product p){
		Product theProduct = productService.findOne(ID);
		if(theProduct == null) {
			return ResponseEntity.notFound().build();
		}
		theProduct.setProductName(p.getProductName());
		theProduct.setProductURL(p.getProductURL());
		theProduct.setPrice(p.getPrice());
		theProduct.setColour(p.getColour());
		theProduct.setDimension(p.getDimension());
		theProduct.setManufacture(p.getManufacture());
		theProduct.setProductCategory(p.getProductCategory());
		theProduct.setQuantity(p.getQuantity());
		
		Product updatedProduct = productService.addProduct(theProduct);
		return ResponseEntity.ok().body(updatedProduct);
	}
	
}