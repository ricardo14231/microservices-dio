package com.dio.microservices.productcatalog.Utils;

import com.dio.microservices.productcatalog.model.ProductModel;

public class ProductBuilder {

    public static ProductModel createProduct() {
        return ProductModel.builder()
                .name("Product 1")
                .amount(10)
                .build();
    }

    public static ProductModel updateProduct() {
        return ProductModel.builder()
                .id(1L)
                .name("Product 1 update")
                .amount(10)
                .build();
    }

}
