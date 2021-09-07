package com.dio.microservices.shoppingcart.utils;

import com.dio.microservices.shoppingcart.model.CartModel;
import com.dio.microservices.shoppingcart.model.ItemModel;

import java.util.Collections;

public class CartBuilder {

    public static CartModel createCart() {
        return CartModel.builder()
                .id(1L)
                .items(Collections.singletonList(ItemModel.builder()
                        .idProduct(1L)
                        .amount(1)
                        .build()))
                .build();
    }
}
