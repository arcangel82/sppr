package com.napptilus.sppr.service;

import com.napptilus.sppr.entity.Product;

import java.time.LocalDateTime;

public interface ProductService {
    Product getPriceProduct(LocalDateTime dateApp, String productId, Integer brandId);
}
