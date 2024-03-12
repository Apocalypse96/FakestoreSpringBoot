package com.example.product.service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;

public class CartService {
    @SuppressWarnings("unused")
    private Map<Producer, Integer> cart = new HashMap<>();

    public void addProduct(Producer product) {
        
       
    }

    public void removeProduct(Producer product) {
       
        
    }

    public Map<Producer, Integer> getCartContents() {
        return cart;
       
        
    }
    
}


