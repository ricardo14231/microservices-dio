package com.dio.microservices.shoppingcard.shoppingcard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash("cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartModel {
    @Id
    private Long id;
    private List<ItemModel> items;
}
