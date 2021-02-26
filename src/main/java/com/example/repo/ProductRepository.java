package com.example.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, BigInteger>{

    List<Product> findAll();
    
    List<Product> findByProductCategory(String productCategory);
    
    List<Product> findByProductId(BigInteger productId);
    
    List<Product> findByProductPrice(BigInteger price);
}
