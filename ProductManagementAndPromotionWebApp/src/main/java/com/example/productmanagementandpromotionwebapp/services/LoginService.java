package com.example.productmanagementandpromotionwebapp.services;

import com.example.productmanagementandpromotionwebapp.entities.User;
import com.example.productmanagementandpromotionwebapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    final UserRepository userRepository;

    public User userLogin(User user){
        Optional<User> optionalUser= userRepository.findByEmailAndPasswordIgnoreCase(user.getEmail(), user.getPassword());

        if (optionalUser.isPresent()) {
            User u = optionalUser.get();
            return u; //mail and password is correct
        }
        return null; //mail and password is not correct

    }


}
