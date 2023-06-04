package com.example.productmanagementandpromotionwebapp.services;

import com.example.productmanagementandpromotionwebapp.entities.Product;
import com.example.productmanagementandpromotionwebapp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    final ProductRepository productRepository;



    public List<Product> searchList (String title, String detail){
        return productRepository.findByTitleContainsOrDetailContainsOrderByPidDesc(title, detail);
    }
}
