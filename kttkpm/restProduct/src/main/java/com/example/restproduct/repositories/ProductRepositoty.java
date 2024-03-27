package com.example.restproduct.repositories;

import com.example.restproduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoty extends JpaRepository<Product, Long> {
}
