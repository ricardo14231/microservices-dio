package com.dio.microservices.shoppingcard.shoppingcard.utils;

import com.dio.microservices.shoppingcard.shoppingcard.dto.CartDTO;
import com.dio.microservices.shoppingcard.shoppingcard.dto.ItemDTO;
import com.dio.microservices.shoppingcard.shoppingcard.model.CartModel;
import com.dio.microservices.shoppingcard.shoppingcard.model.ItemModel;

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
