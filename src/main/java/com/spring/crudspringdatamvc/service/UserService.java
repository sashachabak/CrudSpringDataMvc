package com.spring.crudspringdatamvc.service;

import com.spring.crudspringdatamvc.entity.User;
import com.spring.crudspringdatamvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exist"));
    }
}
