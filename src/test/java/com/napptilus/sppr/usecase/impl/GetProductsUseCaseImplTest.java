package com.napptilus.sppr.usecase.impl;

import com.napptilus.sppr.entity.Product;
import com.napptilus.sppr.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class GetProductsUseCaseImplTest {

    @Mock
    ProductService productService;

    GetProductsUseCaseImpl getProductsUseCase;

    @BeforeEach
    void setUp(){
        this.getProductsUseCase=new GetProductsUseCaseImpl(this.productService);
    }

    @AfterEach
    void reset() {
        verifyNoMoreInteractions(this.productService);
    }

    @Test
    void shouldReturnThrowExceptionWhenErrors() {
        // GIVEN
        LocalDateTime  localDateTime= null;
        String productId = "";
        Integer brandId = 0 ;

        // WHEN
        final IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () ->
                        this.getProductsUseCase.getPriceProduct(
                                localDateTime,
                                productId,
                                brandId));

        // THEN
        assertNotNull(exception);
        assertEquals("Valores invalidos", exception.getMessage());

        verifyNoInteractions(this.productService);
    }

    @Test
    void shouldReturnProductGivenCorrectValues() {
        // GIVEN
        LocalDateTime  localDateTime= LocalDateTime.parse("2023-05-12T10:00");
        String productId = "1";
        Integer brandId = 1 ;
        Product productExpected=new Product(1L,"1","1", LocalDateTime.parse("2023-01-01T10:00"),LocalDateTime.parse("2023-12-31T10:00"),"36","EUR","1","0");
        when(this.productService.getPriceProduct(localDateTime, productId,brandId)).thenReturn(productExpected);

        // WHEN

        Product productResult=this.getProductsUseCase.getPriceProduct(localDateTime,productId,brandId);

        // THEN
        assertNotNull(productResult);
        assertEquals("1", productResult.getProductId());
        assertEquals("1", productResult.getBrandId());
        assertEquals(LocalDateTime.parse("2023-01-01T10:00"), productResult.getFromDateApplication());
        assertEquals(LocalDateTime.parse("2023-12-31T10:00"), productResult.getToDateApplication());
        assertEquals("36", productResult.getPriceProduct());
        assertEquals("EUR", productResult.getPriceCurrency());

        verify(this.productService).getPriceProduct(localDateTime,productId,brandId);
    }

}