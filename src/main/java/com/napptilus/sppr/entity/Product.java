package com.napptilus.sppr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "PRICES" )
public class Product{

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        Long Id;

        @Column(name = "PRODUCT_ID")
        String productId;

        @Column(name = "BRAND_ID")
        String brandId;

        @Column(name = "START_DATE")
        LocalDateTime fromDateApplication;

        @Column(name = "END_DATE")
        LocalDateTime toDateApplication;

        @Column(name = "PRICE")
        String priceProduct;

        @Column(name = "CURR")
        String priceCurrency;

        @Column(name = "PRIORITY")
        String priorityProduct;

        @Column(name = "PRICE_LIST")
        String priceList;
}