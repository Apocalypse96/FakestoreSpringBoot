package com.example.product.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.dto.FakeStoreProductDto;
import com.example.product.service.ProductService;

import scala.Product;
import scala.collection.immutable.LazyList;

@RestController
public class ProductController {
    @Autowired
    ProductService ps;
    

    @GetMapping("/products/")
    public FakeStoreProductDto[] getAllproducts(){
       
        return ps.getAllproducts();
       
    } 
    
    @GetMapping("/products/{id}")
    public FakeStoreProductDto getProductsbyId(@PathVariable Long id){
       

        return ps.getProductbyId(id);
    }

    private Map<Producer, Integer> cart = new HashMap<>();

    @GetMapping("/cart/add/{id}")
    public void addProduct(Producer product) {
        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + 1);
        } else {
            cart.put(product, 1);
        }
       
    }

    
    
    @GetMapping("/cart/remove/{id}")
    public void removeProduct(Producer product) {
        if (cart.containsKey(product)) {
            if (cart.get(product) > 1) {
                cart.put(product, cart.get(product) - 1);
            } else {
                cart.remove(product);
            }
        }
        
    }

    @GetMapping("/cart/contents")
    public LazyList<Producer> viewCart() {
        ArrayList list = new ArrayList;
        for (Map.Entry<Producer) entry : cart.entrySet()) {
            int count = entry.getValue();
            for (int i=0;i <count;i++) {
               list.add(entry.getKey());
            }
            
        }
       Collection.sort(list);
       return new LazyList<>(list);
    }

    
    

    public Map<Producer, Integer> getCartContents() {
        return cart;
        
    }
}
