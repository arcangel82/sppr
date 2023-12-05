package com.napptilus.sppr.mapper;


import com.napptilus.sppr.controller.dto.ProductResponseDTO;
import com.napptilus.sppr.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    public ProductResponseDTO toProductResponseDTO(Product productPrice);
}
