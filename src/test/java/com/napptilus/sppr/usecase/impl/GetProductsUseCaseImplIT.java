package com.napptilus.sppr.usecase.impl;

import com.napptilus.sppr.entity.Product;
import com.napptilus.sppr.repository.ProductDaoRepository;
import com.napptilus.sppr.service.ProductService;
import com.napptilus.sppr.service.impl.DefaultProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DirtiesContext
@SpringBootTest(classes = {GetProductsUseCaseImpl.class, ProductService.class, DefaultProductService.class, ProductDaoRepository.class})
public class GetProductsUseCaseImplIT {

    @Mock
    static ProductService productService;

    @MockBean
    ProductDaoRepository productDaoRepository;

    @Autowired
    GetProductsUseCaseImpl getProductsUseCase;

    @TestConfiguration
    static class TestConfig {

        @Bean
        ProductService productService() {
            return productService;
        }

    }

    @Test
    void shouldReturnProducts(){
        // GIVEN
        LocalDateTime localDateTime =LocalDateTime.parse("2020-06-21T10:00");
        String productId = "35455";
        Integer brandId = 1 ;
        Product productExpected= new Product(1L,"1","1",LocalDateTime.parse("2023-01-01T10:00"),LocalDateTime.parse("2023-12-31T10:00"),"36","EUR","1","1");
        when(this.productDaoRepository.getPricebyProduct(localDateTime, productId,brandId)).thenReturn(productExpected);

        // WHEN
        Product productResult=this.getProductsUseCase.getPriceProduct(localDateTime,productId,brandId);

        // THEN
        assertNotNull(productResult);
        assertEquals(productExpected, productResult);

    }

    @Test
    void shouldReturnExceptionGivenWrongValues(){
        // GIVEN
        LocalDateTime localDateTime =LocalDateTime.parse("2020-06-21T10:00");
        String productId = "35455";
        Integer brandId = 0 ;

        // WHEN
        IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () ->
                this.getProductsUseCase.getPriceProduct(
                        localDateTime,
                        productId,
                        brandId));
        // THEN
        assertNotNull(exception);
        assertEquals("Valores invalidos", exception.getMessage());

    }
}

