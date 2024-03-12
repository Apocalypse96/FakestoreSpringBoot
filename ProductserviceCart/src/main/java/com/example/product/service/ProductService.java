package com.example.product.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.product.dto.FakeStoreProductDto;

@Service
public class ProductService {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://fakestoreapi.com";

    public FakeStoreProductDto[] getAllproducts(){
        FakeStoreProductDto[] response = restTemplate.getForObject(url + "/products/",FakeStoreProductDto[].class);
       return  response; 
       
    } 

    public FakeStoreProductDto getProductbyId(Long id){
        var response = restTemplate.getForObject(url + "/products/"+id ,FakeStoreProductDto.class);
        return response;
    }
    
}
