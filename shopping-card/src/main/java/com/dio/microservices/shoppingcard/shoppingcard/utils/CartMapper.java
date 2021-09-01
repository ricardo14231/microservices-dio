package com.dio.microservices.shoppingcard.shoppingcard.utils;

import com.dio.microservices.shoppingcard.shoppingcard.dto.CartDTO;
import com.dio.microservices.shoppingcard.shoppingcard.dto.ItemDTO;
import com.dio.microservices.shoppingcard.shoppingcard.model.CartModel;
import com.dio.microservices.shoppingcard.shoppingcard.model.ItemModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {

    public static CartModel toModel(CartDTO cartDTO) {
        CartModel cart = new CartModel(cartDTO.getId(), toItemModel(cartDTO.getItems()));
        return cart;
    }

    public static CartDTO toDTO(CartModel cartModel) {
        CartDTO cart = new CartDTO(cartModel.getId(), toItemDTO(cartModel.getItems()));
        return cart;
    }

    public static List<ItemModel> toItemModel(List<ItemDTO> list) {
        List<ItemModel> itemsModel = new ArrayList<>();
        itemsModel = list.stream()
                .map(l -> {
                    ItemModel item = new ItemModel(l.getIdProduct(), l.getAmount());
                    return item;
                }).collect(Collectors.toList());
        return itemsModel;
    }

    public static List<ItemDTO> toItemDTO(List<ItemModel> list) {
        List<ItemDTO> itemsDTO = new ArrayList<>();
        itemsDTO = list.stream()
                .map(l -> {
                    ItemDTO item = new ItemDTO(l.getIdProduct(), l.getAmount());
                    return item;
                }).collect(Collectors.toList());
        return itemsDTO;
    }
}
