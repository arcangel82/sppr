package com.napptilus.sppr.usecase;

import com.napptilus.sppr.controller.dto.ProductResponseDTO;
import com.napptilus.sppr.entity.Product;

import java.time.LocalDateTime;

public interface GetProductsUseCase {

    Product getPriceProduct(LocalDateTime dateApp, String productId, Integer brandId);
}
