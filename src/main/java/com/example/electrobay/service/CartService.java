package com.example.electrobay.service;

import com.example.electrobay.entity.Cart;

import java.util.Optional;

public interface CartService {
    Cart getCart(int id);
    Cart save(Cart cart);
    void delete(int id);
    Optional<Cart> findById(int id);
}
