package com.napptilus.sppr.controller;

import com.napptilus.sppr.api.ProductApi;
import com.napptilus.sppr.controller.dto.ProductResponseDTO;
import com.napptilus.sppr.entity.Product;
import com.napptilus.sppr.exception.InvalidRequestParameterException;
import com.napptilus.sppr.mapper.ProductMapper;
import com.napptilus.sppr.usecase.GetProductsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final GetProductsUseCase getProductsUseCase;

    private final ProductMapper productMapper;

    @Override
    public ResponseEntity<ProductResponseDTO> getPriceProducts(
            final String dateApp,
            final String productId,
            final Integer brandId) {
        try {
            if((dateApp==null)||(productId==null)||(brandId==null))
                throw new IllegalArgumentException("No values");
            LocalDateTime dateAppDateTime=LocalDateTime.parse(dateApp);
            final Product productPrice= this.getProductsUseCase.getPriceProduct(dateAppDateTime,productId,brandId);
            final ProductResponseDTO productResponse = this.productMapper.toProductResponseDTO(productPrice);

            return ResponseEntity.ok(productResponse);

        } catch (final IllegalArgumentException illegalArgumentException) {
            throw new InvalidRequestParameterException("product", illegalArgumentException.getMessage(),
                    illegalArgumentException.getLocalizedMessage());
        } catch (final DateTimeParseException dateTimeParseException) {
        throw new InvalidRequestParameterException("date", dateTimeParseException.getMessage(),
                dateTimeParseException.getLocalizedMessage());
        }
    }

}
