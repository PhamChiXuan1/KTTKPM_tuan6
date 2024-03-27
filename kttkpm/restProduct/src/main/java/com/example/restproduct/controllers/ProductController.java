package com.example.restproduct.controllers;

import com.example.restproduct.dto.ProductDTO;
import com.example.restproduct.dto.UserDTO;
import com.example.restproduct.model.Product;
import com.example.restproduct.repositories.ProductRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepositoty productRepositoty;

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAPIGateWay(){
        RestTemplate restTemplate = new RestTemplate();
        String request = "http://localhost:9292/api/v1/users";
        UserDTO[] userDTOS = restTemplate.getForObject(request,UserDTO[].class);
        List<Product> products = productRepositoty.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (int i = 0; i< Objects.requireNonNull(userDTOS).length; i++){
            UserDTO userDTO = userDTOS[i];
            Product product = products.get(i);
            ProductDTO productDTO = ProductDTO.builder()
                    .productId(product.getId())
                    .userId(userDTO.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .build();
            productDTOS.add(productDTO);
        }
        return ResponseEntity.ok(productDTOS);
    }
}
