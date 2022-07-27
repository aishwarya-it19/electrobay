package com.example.electrobay.service.impl;

import com.example.electrobay.entity.Cart;
import com.example.electrobay.repository.CartRepository;
import com.example.electrobay.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart getCart(int id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        return optionalCart.isPresent() ? optionalCart.get() : null;
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void delete(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Optional<Cart> findById(int id) {
        return cartRepository.findById(id);
    }

}
