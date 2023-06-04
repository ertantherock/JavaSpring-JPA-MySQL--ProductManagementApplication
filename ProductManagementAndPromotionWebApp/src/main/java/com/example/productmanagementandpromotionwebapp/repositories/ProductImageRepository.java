package com.example.productmanagementandpromotionwebapp.repositories;

import com.example.productmanagementandpromotionwebapp.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    List<ProductImage> findByPidEquals(Long pid);


}