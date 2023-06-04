package com.example.productmanagementandpromotionwebapp.services;

import com.example.productmanagementandpromotionwebapp.entities.User;
import com.example.productmanagementandpromotionwebapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class UserService {
    final UserRepository userRepository;

    public User userSave(User user){
        user.setStatus(true);

        try {
            //save process
           return userRepository.save(user);

        }catch (DataIntegrityViolationException ex) {
            return user;

        }catch (Exception ex2){
            return null;
        }
    }

}
