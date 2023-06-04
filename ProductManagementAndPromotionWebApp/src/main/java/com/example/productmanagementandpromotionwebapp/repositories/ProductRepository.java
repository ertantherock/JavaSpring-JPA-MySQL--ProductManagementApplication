package com.example.productmanagementandpromotionwebapp.repositories;

import com.example.productmanagementandpromotionwebapp.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCidEqualsAllIgnoreCase(Long cid, Pageable pageable);

    Page<Product> findByCidEqualsAllIgnoreCaseOrderByPidDesc(Long cid, Pageable pageable);

    boolean existsByPidEqualsAndCidEquals(Long pid, Long cid);

    List<Product> findByTitleContainsOrDetailContainsOrderByPidDesc(String title, String detail);






}