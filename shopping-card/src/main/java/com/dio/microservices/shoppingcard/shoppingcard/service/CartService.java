package com.dio.microservices.shoppingcard.shoppingcard.service;

import com.dio.microservices.shoppingcard.shoppingcard.dto.CartDTO;
import com.dio.microservices.shoppingcard.shoppingcard.model.CartModel;
import com.dio.microservices.shoppingcard.shoppingcard.model.ItemModel;
import com.dio.microservices.shoppingcard.shoppingcard.repository.CartRepository;
import com.dio.microservices.shoppingcard.shoppingcard.utils.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public CartDTO addCart(CartDTO cartDTO) {
        Optional<CartModel> findCart = cartRepository.findById(cartDTO.getId());
        CartModel cartToSave = CartMapper.toModel(cartDTO);

        if(findCart.isPresent()) {
            List<ItemModel> newItems = findCart.get().getItems();
            newItems.addAll(cartToSave.getItems());
            cartToSave.setItems(newItems);
        }

        CartDTO cartSaved = CartMapper.toDTO(cartRepository.save(cartToSave));
        return cartSaved;
    }

    public CartDTO findByIdCart(Long id) {
        CartModel cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());

        return CartMapper.toDTO(cart);
    }

    public String deleteCart(Long id) {
        cartRepository.deleteById(id);
        return String.format("Cart com ID: %o deletado!", id);
    }
}
