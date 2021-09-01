package com.dio.microservices.productcatalog.repository;

import com.dio.microservices.productcatalog.model.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long> {
}
