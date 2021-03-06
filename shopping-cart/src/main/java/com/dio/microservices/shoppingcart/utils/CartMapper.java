package com.dio.microservices.shoppingcart.utils;

import com.dio.microservices.shoppingcart.dto.CartDTO;
import com.dio.microservices.shoppingcart.model.CartModel;
import com.dio.microservices.shoppingcart.dto.ItemDTO;
import com.dio.microservices.shoppingcart.model.ItemModel;

import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {

    public static CartModel toModel(CartDTO cartDTO) {
        return new CartModel(cartDTO.getId(), toItemModel(cartDTO.getItems()));
    }

    public static CartDTO toDTO(CartModel cartModel) {
        return new CartDTO(cartModel.getId(), toItemDTO(cartModel.getItems()));
    }

    private static List<ItemModel> toItemModel(List<ItemDTO> list) {
        List<ItemModel> itemsModel;
        itemsModel = list.stream()
                .map(l -> new ItemModel(l.getIdProduct(), l.getAmount())).collect(Collectors.toList());
        return itemsModel;
    }

    private static List<ItemDTO> toItemDTO(List<ItemModel> list) {
        List<ItemDTO> itemsDTO;
        itemsDTO = list.stream()
                .map(l -> new ItemDTO(l.getIdProduct(), l.getAmount())).collect(Collectors.toList());
        return itemsDTO;
    }
}
