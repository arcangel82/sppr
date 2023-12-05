package com.napptilus.sppr.controller;

import com.napptilus.sppr.controller.dto.ProductResponseDTO;
import com.napptilus.sppr.exception.InvalidRequestParameterException;
import com.napptilus.sppr.mapper.ProductMapper;
import com.napptilus.sppr.usecase.GetProductsUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class ProductControllerTest {

    @Mock
    GetProductsUseCase getProductsUseCase;

    @Mock
    ProductMapper productMapper;

    ProductController productController;

    @BeforeEach
    void setUp() {
        this.productController = new ProductController(this.getProductsUseCase,this.productMapper);
    }

    @Test
    void shouldReturnPriceProducts() {

        // GIVEN
        String  dateApp= "2023-05-12T10:00";
        LocalDateTime localDateTime =LocalDateTime.parse("2023-05-12T10:00");
        String productId = "1";
        Integer brandId = 1 ;
        ProductResponseDTO productExpected=new ProductResponseDTO("1","1",LocalDateTime.parse("2023-01-01T10:00"),LocalDateTime.parse("2023-12-31T10:00"),"36","EUR");
        when(this.getProductsUseCase.getPriceProduct(localDateTime, productId,brandId)).thenReturn(null);
        when(this.productMapper.toProductResponseDTO(null)).thenReturn(productExpected);

        // WHEN
        final ResponseEntity<ProductResponseDTO> reponseController = this.productController.getPriceProducts(dateApp,productId,brandId);

        // THEN
        assertNotNull(reponseController);
        assertNotNull(reponseController.getBody());
        assertEquals(HttpStatus.OK, reponseController.getStatusCode());
        assertEquals(productExpected, reponseController.getBody());

        verify(this.getProductsUseCase).getPriceProduct(localDateTime, productId,brandId);
        verify(this.productMapper).toProductResponseDTO(null);
    }

    @Test
    void shouldThrowInvalidRequestParameterException() {
        //WHEN
        final InvalidRequestParameterException exception =
                assertThrows(InvalidRequestParameterException.class, () ->
                        this.productController.getPriceProducts(
                                null,
                                null,
                                null));

        // THEN
        assertNotNull(exception);
        assertEquals("product", exception.getName());
        assertEquals("No values", exception.getMessage());

        verifyNoInteractions(this.getProductsUseCase);
        verifyNoInteractions(this.productMapper);
    }
}