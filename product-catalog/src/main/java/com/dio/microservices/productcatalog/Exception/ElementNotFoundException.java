package com.dio.microservices.productcatalog.Exception;

import java.util.NoSuchElementException;

public class ElementNotFoundException extends NoSuchElementException {

    public ElementNotFoundException(Long id) {
        super(String.format("Produto com ID: %o não encontrado.", id));
    }
}
