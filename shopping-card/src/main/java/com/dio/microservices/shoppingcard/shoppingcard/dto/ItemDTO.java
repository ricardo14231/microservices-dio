package com.dio.microservices.shoppingcard.shoppingcard.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private Long idProduct;
    private int amount;
}
