package com.napptilus.sppr.service.impl;

import com.napptilus.sppr.entity.Product;
import com.napptilus.sppr.repository.ProductDaoRepository;
import com.napptilus.sppr.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class DefaultProductService implements ProductService {

    private final ProductDaoRepository productDaoRepository;

    public DefaultProductService(ProductDaoRepository productDaoRepository){
        this.productDaoRepository=productDaoRepository;
    }

    @Override
    public Product getPriceProduct(LocalDateTime dateApp, String productId, Integer brandId) {

        return productDaoRepository.getPricebyProduct(dateApp,productId,brandId);

    }
}
