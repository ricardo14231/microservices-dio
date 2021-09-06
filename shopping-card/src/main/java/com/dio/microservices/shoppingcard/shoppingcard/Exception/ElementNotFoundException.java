package com.dio.microservices.shoppingcard.shoppingcard.Exception;

import java.util.NoSuchElementException;

public class ElementNotFoundException extends NoSuchElementException {

    public ElementNotFoundException(Long id) {
        super(String.format("Carrinho com ID: %o não encontrado.", id));
    }
}
