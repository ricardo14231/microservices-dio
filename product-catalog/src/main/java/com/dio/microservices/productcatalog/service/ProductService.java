package com.dio.microservices.productcatalog.service;

import com.dio.microservices.productcatalog.Exception.ElementNotFoundException;
import com.dio.microservices.productcatalog.Utils.mapper.ProductMapper;
import com.dio.microservices.productcatalog.dto.ProductDTO;
import com.dio.microservices.productcatalog.model.ProductModel;
import com.dio.microservices.productcatalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductModel productToSave = ProductMapper.toModel(productDTO);
        return ProductMapper.toDTO(productRepository.save(productToSave));
    }

    public ProductDTO findByIdProduct(Long id) {
        ProductModel productModel = productRepository.findById(id).orElseThrow(() -> new ElementNotFoundException(id));
        return ProductMapper.toDTO(productModel);
    }

}
