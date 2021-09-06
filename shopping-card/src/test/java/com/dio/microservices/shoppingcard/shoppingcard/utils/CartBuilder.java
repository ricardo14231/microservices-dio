package com.dio.microservices.shoppingcard.shoppingcard.utils;

import com.dio.microservices.shoppingcard.shoppingcard.model.CartModel;
import com.dio.microservices.shoppingcard.shoppingcard.model.ItemModel;

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
