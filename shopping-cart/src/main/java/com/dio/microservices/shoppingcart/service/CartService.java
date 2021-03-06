package com.dio.microservices.shoppingcart.service;

import com.dio.microservices.shoppingcart.Exception.ElementNotFoundException;
import com.dio.microservices.shoppingcart.repository.CartRepository;
import com.dio.microservices.shoppingcart.dto.CartDTO;
import com.dio.microservices.shoppingcart.model.CartModel;
import com.dio.microservices.shoppingcart.model.ItemModel;
import com.dio.microservices.shoppingcart.utils.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CartService {

    private final CartRepository cartRepository;

    public CartDTO addCart(CartDTO cartDTO) {
        CartModel newCart = CartMapper.toModel(cartDTO);

        Optional<CartModel> cartSaved = cartRepository.findById(cartDTO.getId());

        if(cartSaved.isPresent()) {
            List<ItemModel> itemsSaved = cartSaved.get().getItems();
            newCart.getItems().addAll(itemsSaved);
        }

        return CartMapper.toDTO(cartRepository.save(newCart));
    }

    public CartDTO findByIdCart(Long id) {
        CartModel cart = verifyIfExists(id);

        return CartMapper.toDTO(cart);
    }

    public String deleteCart(Long id) {
        CartModel cartToDelete = verifyIfExists(id);

        cartRepository.delete(cartToDelete);
        return String.format("Cart com ID: %o deletado!", id);
    }

    private CartModel verifyIfExists(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id));
    }
}
