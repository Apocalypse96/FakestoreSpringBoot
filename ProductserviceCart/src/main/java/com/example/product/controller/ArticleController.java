package com.example.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.service.ProductService;

@RestController
public class ArticleController {
    @GetMapping("/articles/")
    public String getAllArticle(){
        return "All Articles";
    }


    // @GetMapping("/products/{id}")
    // public String getProductById(@PathVariable Long id){
    //     ProductService ps = new ProductService();

    //     return ps.getProductbyId(id);
    // }
    
}
