package com.cg.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.demo.entity.Product;


/******************************************
- File Name      : ProductRepository.java
- Author           : Capgemini
- Creation Date    : 13-08-2020
- Description      : This Repository class extends JpaRepository which gets all the CRUD operations for Dao Class
 ******************************************/


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
