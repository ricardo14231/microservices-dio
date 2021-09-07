package com.dio.microservices.shoppingcart.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("item")
@Getter
@Setter
//@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {

    private Long idProduct;
    private int amount;
}
