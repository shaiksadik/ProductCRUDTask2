package com.example.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "mobigesture")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "product_id")
    private int productId;
    
    @Column(name= "product_category")
    private String productCategory;
    
    @Column(name= "product_name")
    private String productName;
    
    @Column(name= "product_price")
    private BigInteger productPrice;

    public Product(int product_id, String productName, BigInteger productPrice) {

        super();
        this.productId = product_id;
        this.productName = productName;
        this.productPrice = productPrice;
    }
    
    public Product() {
        
    }
}
