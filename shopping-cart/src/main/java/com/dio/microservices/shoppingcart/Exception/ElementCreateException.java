package com.dio.microservices.shoppingcart.Exception;

public class ElementCreateException extends NullPointerException {

    public ElementCreateException() {
        super(String.format("Erro ao criar o carrinho."));
    }
}
