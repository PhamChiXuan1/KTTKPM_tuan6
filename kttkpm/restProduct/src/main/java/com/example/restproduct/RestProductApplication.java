package com.example.restproduct;

import com.example.restproduct.model.Product;
import com.example.restproduct.repositories.ProductRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class RestProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestProductApplication.class, args);
    }

    @Autowired
    private ProductRepositoty productRepositoty;

//    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Random random = new Random();

            for (int i = 0; i < 5; i++) {
                Product product = new Product("name product " + i, random.nextDouble());
                productRepositoty.save(product);
            }
        };
    }
}
