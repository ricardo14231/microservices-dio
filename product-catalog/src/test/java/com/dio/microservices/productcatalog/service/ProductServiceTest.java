package com.dio.microservices.productcatalog.service;

import com.dio.microservices.productcatalog.Exception.ElementNotFoundException;
import com.dio.microservices.productcatalog.Utils.ProductBuilder;
import com.dio.microservices.productcatalog.Utils.mapper.ProductMapper;
import com.dio.microservices.productcatalog.dto.ProductDTO;
import com.dio.microservices.productcatalog.model.ProductModel;
import com.dio.microservices.productcatalog.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DisplayName("Product service.")
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        ProductModel product = ProductBuilder.createProduct();

        BDDMockito.when(productRepository.save(Mockito.any())).thenReturn(product);

        BDDMockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(product));
    }

    @Test
    @DisplayName("Save product successful.")
    void save_ReturnsProductDTO_whenSuccessful() {
        ProductDTO expectedProduct = ProductMapper.toDTO(ProductBuilder.createProduct());

        ProductDTO productSaved = productService.createProduct(expectedProduct);

        Assertions.assertEquals(expectedProduct.getId(), productSaved.getId());
        Assertions.assertEquals(expectedProduct.getName(), productSaved.getName());
    }

    @Test
    @DisplayName("Returns the product whin findById.")
    void findByIdProduct_ReturnProduct_whenSuccessful() {
        ProductDTO expectedProduct = ProductMapper.toDTO(ProductBuilder.createProduct());

        ProductDTO productFind = productService.findByIdProduct(1L);

        Assertions.assertEquals(expectedProduct.getId(), productFind.getId());
        Assertions.assertEquals(expectedProduct.getName(), productFind.getName());
    }

    @Test
    @DisplayName("Returns ElementNotFoundException to findById.")
    void findByIdProduct_ReturnProduct_whenElementNotFoundException() {
        BDDMockito.doReturn(Optional.empty()).when(productRepository).findById(Mockito.anyLong());

        Assertions.assertThrows(ElementNotFoundException.class, () -> productService.findByIdProduct(1L));
    }
}