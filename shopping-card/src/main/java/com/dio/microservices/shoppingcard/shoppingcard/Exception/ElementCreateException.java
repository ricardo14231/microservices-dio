package com.dio.microservices.shoppingcard.shoppingcard.Exception;

public class ElementCreateException extends NullPointerException {

    public ElementCreateException() {
        super(String.format("Erro ao criar o carrinho."));
    }
}
