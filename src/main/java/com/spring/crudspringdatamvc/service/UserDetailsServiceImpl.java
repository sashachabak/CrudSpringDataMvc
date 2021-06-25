package com.spring.crudspringdatamvc.service;

import com.spring.crudspringdatamvc.dto.UserDto;
import com.spring.crudspringdatamvc.entity.User;
import com.spring.crudspringdatamvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;
    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exist!"));
        return UserDto.fromUser(user);
    }
}
