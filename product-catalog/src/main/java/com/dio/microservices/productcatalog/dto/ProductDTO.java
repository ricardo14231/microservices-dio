package com.dio.microservices.productcatalog.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    @Min(0)
    private Integer amount;
}
