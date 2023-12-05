package com.napptilus.sppr.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.napptilus.sppr.controller.dto.ProductResponseDTO;
import com.napptilus.sppr.entity.Product;
import com.napptilus.sppr.mapper.ProductMapper;
import com.napptilus.sppr.mapper.ProductMapperImpl;
import com.napptilus.sppr.usecase.GetProductsUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext
@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = {ProductController.class, ProductMapperImpl.class})
public class ProductControllerIT {

    @MockBean
    GetProductsUseCase getProductsUseCase;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @AfterEach
    void reset() {
        verifyNoMoreInteractions(this.getProductsUseCase);
    }

    @Test
    void shouldReturnProductResponse() throws Exception{
        // GIVEN
        String  dateApp= "2020-06-21T10:00";
        LocalDateTime localDateTime =LocalDateTime.parse("2020-06-21T10:00");
        String productId = "35455";
        Integer brandId = 1 ;
        Product productExpected= new Product(1L,"1","1",LocalDateTime.parse("2023-01-01T10:00"),LocalDateTime.parse("2023-12-31T10:00"),"36","EUR","1","1");
        ProductResponseDTO productDTOExpected=new ProductResponseDTO("1","1",LocalDateTime.parse("2023-01-01T10:00"),LocalDateTime.parse("2023-12-31T10:00"),"36","EUR");
        when(this.getProductsUseCase.getPriceProduct(localDateTime, productId,brandId)).thenReturn(productExpected);

        // WHEN
        final MockHttpServletResponse response = this.mockMvc.perform(get("/product/"+dateApp+"/"+productId+"/"+brandId+"/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        final ProductResponseDTO result=this.objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {});

        assertNotNull(result);
        assertEquals(productDTOExpected, result);

        verify(this.getProductsUseCase).getPriceProduct(localDateTime, productId,brandId);
    }

}
