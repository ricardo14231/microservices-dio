package com.dio.microservices.productcatalog.controller;

import com.dio.microservices.productcatalog.dto.ProductDTO;
import com.dio.microservices.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findByIdProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findByIdProduct(id), HttpStatus.OK);
    }

}
