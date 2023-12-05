package com.napptilus.sppr.usecase.impl;

import com.napptilus.sppr.entity.Product;
import com.napptilus.sppr.service.ProductService;
import com.napptilus.sppr.usecase.GetProductsUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class GetProductsUseCaseImpl implements GetProductsUseCase {

    private final ProductService productService;

    public GetProductsUseCaseImpl(final ProductService productService){
        this.productService=productService;
    }

    @Override
    public Product getPriceProduct(LocalDateTime dateApp, String productId, Integer brandId) {

        if ((productId.isEmpty())||(brandId<1)) {
            throw new IllegalArgumentException("Valores invalidos");
        }

        return productService.getPriceProduct(dateApp,productId,brandId);
    }
}
