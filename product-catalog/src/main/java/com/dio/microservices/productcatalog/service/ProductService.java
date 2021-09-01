package com.dio.microservices.productcatalog.service;

import com.dio.microservices.productcatalog.dto.ProductDTO;
import com.dio.microservices.productcatalog.model.ProductModel;
import com.dio.microservices.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductModel productToSave = toModel(productDTO);
        return toDTO(productRepository.save(productToSave));
    }

    public ProductDTO findByIdProduct(Long id) {
        ProductModel productModel = productRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return toDTO(productModel);
    }

    private ProductModel toModel(ProductDTO productDTO) {
        ProductModel productModel;
        return productModel = new ProductModel(productDTO.getId(), productDTO.getName(), productDTO.getAmount());
    }

    private ProductDTO toDTO(ProductModel productModel) {
        ProductDTO productDTO;
        return productDTO = new ProductDTO(productModel.getId(), productModel.getName(), productModel.getAmount());
    }
}
