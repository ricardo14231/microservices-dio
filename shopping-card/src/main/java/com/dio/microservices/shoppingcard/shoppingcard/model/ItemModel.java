package com.dio.microservices.shoppingcard.shoppingcard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {

    private Long idProduct;
    private int amount;
}
