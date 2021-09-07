package com.dio.microservices.shoppingcart.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    @NotNull
    private Long idProduct;

    @NotEmpty
    private int amount;
}
