package com.dio.microservices.shoppingcard.shoppingcard.service;

import com.dio.microservices.shoppingcard.shoppingcard.Exception.ElementNotFoundException;
import com.dio.microservices.shoppingcard.shoppingcard.dto.CartDTO;
import com.dio.microservices.shoppingcard.shoppingcard.model.CartModel;
import com.dio.microservices.shoppingcard.shoppingcard.model.ItemModel;
import com.dio.microservices.shoppingcard.shoppingcard.repository.CartRepository;
import com.dio.microservices.shoppingcard.shoppingcard.utils.CartMapper;
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
