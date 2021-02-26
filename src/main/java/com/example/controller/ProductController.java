
package com.example.controller;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Product;
import com.example.repo.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/mobigesture")
public class ProductController {

    @Autowired
    private ProductRepository prodRepo;

    @GetMapping(value = "categoryName", produces = "application/json", consumes = "application/json")
    public List<Product> addProduct(@PathVariable
    String categoryName, @PathVariable
    double price) {

        List<Product> product = prodRepo.findByProductCategory(categoryName);
        return product;
    }

    @PostMapping
    public Product addProduct(@RequestBody
    Product product) {

        return this.prodRepo.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {

        return this.prodRepo.findAll();
    }

    @GetMapping("/{categoryName}/{price}")
    public List<Product> getAllProductsByCategory(@PathVariable
    String categoryName, @PathVariable
    BigInteger price) {

        List<Product> product = prodRepo.findByProductCategory(categoryName);
        List<Product> collect = product.stream().filter(prod -> prod.getProductPrice().equals(price)).collect(Collectors.toList());
        log.info("collection data: " + collect);
        if ( collect.isEmpty() ) {
            log.info("There is no product available with given price: " + price);
        }
        return collect;
    }
}
