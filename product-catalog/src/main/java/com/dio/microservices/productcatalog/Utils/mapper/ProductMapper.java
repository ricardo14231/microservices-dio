package com.dio.microservices.productcatalog.Utils.mapper;

import com.dio.microservices.productcatalog.dto.ProductDTO;
import com.dio.microservices.productcatalog.model.ProductModel;

public class ProductMapper {

    public static ProductModel toModel(ProductDTO productDTO) {
        ProductModel productModel;
        return productModel = new ProductModel(productDTO.getId(), productDTO.getName(), productDTO.getAmount());
    }

    public static ProductDTO toDTO(ProductModel productModel) {
        ProductDTO productDTO;
        return productDTO = new ProductDTO(productModel.getId(), productModel.getName(), productModel.getAmount());
    }
}
