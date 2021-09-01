package com.dio.microservices.shoppingcard.shoppingcard.repository;

import com.dio.microservices.shoppingcard.shoppingcard.model.CartModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<CartModel, Long> {
}
