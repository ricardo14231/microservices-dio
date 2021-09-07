package com.dio.microservices.shoppingcart.service;

import com.dio.microservices.shoppingcart.Exception.ElementNotFoundException;
import com.dio.microservices.shoppingcart.repository.CartRepository;
import com.dio.microservices.shoppingcart.dto.CartDTO;
import com.dio.microservices.shoppingcart.model.CartModel;
import com.dio.microservices.shoppingcart.utils.CartBuilder;
import com.dio.microservices.shoppingcart.utils.CartMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DisplayName("Cart service.")
class CartServiceTest {

    @InjectMocks
    private CartService cartService;

    @Mock
    private CartRepository cartRepository;

    @BeforeEach
    void setUp() {
        CartModel cart = CartBuilder.createCart();

        BDDMockito.when(cartRepository.save(Mockito.any())).thenReturn(cart);

        BDDMockito.when(cartRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(cart));
    }

    @Test
    @DisplayName("AddCart, returns successful")
    void addCart_returnCartDTO_whenSuccessful() {
        CartDTO expectedCart = CartMapper.toDTO(CartBuilder.createCart());
        CartDTO cartSaved = cartService.addCart(expectedCart);

        Assertions.assertEquals(expectedCart.getId(), cartSaved.getId());
        Assertions.assertEquals(expectedCart.getItems().get(0).getIdProduct(), cartSaved.getItems().get(0).getIdProduct());
        Assertions.assertEquals(expectedCart.getItems().get(0).getAmount(), cartSaved.getItems().get(0).getAmount());
    }

    @Test
    @DisplayName("FindById, returns Cart.")
    void findById_returnCartDTO_whenSuccessful() {
        CartDTO expectedCard = CartMapper.toDTO(CartBuilder.createCart());

        CartDTO resultCartDTO = cartService.findByIdCart(1L);

        Assertions.assertEquals(expectedCard.getId(), resultCartDTO.getId());
        Assertions.assertEquals(expectedCard.getItems(), resultCartDTO.getItems());
    }

    @Test
    @DisplayName("FindById, returns cart not found.")
    void findById_returnElementNotFoundException_whenSuccessful() {
        BDDMockito.doReturn(Optional.empty()).when(cartRepository).findById(Mockito.anyLong());

        Assertions.assertThrows(ElementNotFoundException.class, () -> cartService.findByIdCart(1L));
    }

    @Test
    @DisplayName("Delete, returns message of successful.")
    void delete_returnMessage_whenSuccessful() {
        String responseMessage = cartService.deleteCart(1L);

        Assertions.assertEquals("Cart com ID: 1 deletado!", responseMessage);
        Assertions.assertTrue(responseMessage.contains("1"));
    }

    @Test
    @DisplayName("Delete, returns exception cart not found.")
    void delete_returnElementNotFound_whenSuccessful() {
        BDDMockito.doReturn(Optional.empty()).when(cartRepository).findById(Mockito.anyLong());

        Assertions.assertThrows(ElementNotFoundException.class, () -> cartService.deleteCart(1L));
    }
}