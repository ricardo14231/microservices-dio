package com.dio.microservices.shoppingcart.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    private Long id;

    @NotNull
    private List<ItemDTO> items;
}
