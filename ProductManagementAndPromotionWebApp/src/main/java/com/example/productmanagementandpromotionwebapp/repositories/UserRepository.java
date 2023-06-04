package com.example.productmanagementandpromotionwebapp.repositories;

import com.example.productmanagementandpromotionwebapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPasswordIgnoreCase(String email, String password);


}