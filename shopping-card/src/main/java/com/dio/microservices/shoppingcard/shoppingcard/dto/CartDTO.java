package com.dio.microservices.shoppingcard.shoppingcard.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long id;
    private List<ItemDTO> items;
}
