package com.dio.microservices.shoppingcard.shoppingcard.controller;

import com.dio.microservices.shoppingcard.shoppingcard.dto.CartDTO;
import com.dio.microservices.shoppingcard.shoppingcard.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

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
