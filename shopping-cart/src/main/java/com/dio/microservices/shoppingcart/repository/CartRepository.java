package com.dio.microservices.shoppingcart.repository;

import com.dio.microservices.shoppingcart.model.CartModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<CartModel, Long> {
}
