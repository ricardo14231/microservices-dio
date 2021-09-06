package com.dio.microservices.shoppingcard.shoppingcard.controller;

import com.dio.microservices.shoppingcard.shoppingcard.dto.CartDTO;
import com.dio.microservices.shoppingcard.shoppingcard.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartDTO> createCart(@RequestBody CartDTO cartDTO) {
        return new ResponseEntity<>(cartService.addCart(cartDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(cartService.findByIdCart(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable Long id) {
        return new ResponseEntity<>(cartService.deleteCart(id), HttpStatus.OK);
    }

}
