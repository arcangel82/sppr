package com.napptilus.sppr.api;

import com.napptilus.sppr.controller.dto.ProductResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

public interface ProductApi {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/product/{dateApp}/{productId}/{brandId}/",
            produces = { "application/json" }
    )
    default ResponseEntity<ProductResponseDTO> getPriceProducts(
            @PathVariable("dateApp") String dateApp,
            @PathVariable("productId") String productId,
            @PathVariable("brandId") Integer brandId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
