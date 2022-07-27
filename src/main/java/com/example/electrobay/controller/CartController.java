package com.example.electrobay.controller;


import com.example.electrobay.dto.CartDto;
import com.example.electrobay.entity.Cart;
import com.example.electrobay.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")


public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping(value = "/{id}")
    public Optional<CartDto> findById(@PathVariable("id") Integer id){
        Optional<Cart> optionalCart = cartService.findById(id);
        CartDto cartDto=null;
        if(optionalCart.isPresent()){
            cartDto = new CartDto();
            BeanUtils.copyProperties(optionalCart.get(),cartDto);
        }
        return Optional.ofNullable(cartDto);
    }

    @PostMapping
    public CartDto save(@RequestBody CartDto cartDto){
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartDto, cart);
        Cart returnCart = cartService.save(cart);
        CartDto returnDto = new CartDto();
        BeanUtils.copyProperties(returnCart, returnDto);
        return returnDto;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id){
        cartService.delete(id);
    }
}

