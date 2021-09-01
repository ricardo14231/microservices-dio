package com.dio.microservices.productcatalog.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "product")
public class ProductModel {

    @Id
    private Long id;
    private String name;
    private Integer amount;

}
