package com.napptilus.sppr.repository;

import com.napptilus.sppr.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class ProductDaoRepositoryTest {

    @Mock
    ProductDaoRepository productDaoRepository;

    @Test
    void shouldRetrunProductGivenCorrectValues(){
        // GIVEN
        LocalDateTime localDateTime =LocalDateTime.parse("2023-05-12T10:00");
        String productId = "1";
        Integer brandId = 1 ;
        Product productExpected= new Product(1L,"1","1",LocalDateTime.parse("2023-01-01T10:00"),LocalDateTime.parse("2023-12-31T10:00"),"36","EUR","1","1");
        when(this.productDaoRepository.getPricebyProduct(localDateTime, productId,brandId)).thenReturn(productExpected);

        // WHEN
        Product productReponse=this.productDaoRepository.getPricebyProduct(localDateTime,productId,brandId);

        // THEN
        assertNotNull(productReponse);
        assertEquals("1", productReponse.getProductId());
        assertEquals("1", productReponse.getBrandId());
        assertEquals(LocalDateTime.parse("2023-01-01T10:00"), productReponse.getFromDateApplication());
        assertEquals(LocalDateTime.parse("2023-12-31T10:00"), productReponse.getToDateApplication());
        assertEquals("36", productReponse.getPriceProduct());
        assertEquals("EUR", productReponse.getPriceCurrency());
        assertEquals("1", productReponse.getPriorityProduct());
        assertEquals("1", productReponse.getPriceList());

        verify(this.productDaoRepository).getPricebyProduct(localDateTime,productId,brandId);

    }

}