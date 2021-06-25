package com.spring.crudspringdatamvc.repository;

import com.spring.crudspringdatamvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> getUserByUsername(String username);
}
