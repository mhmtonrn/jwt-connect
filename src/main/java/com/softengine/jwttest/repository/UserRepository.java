package com.softengine.jwttest.repository;

import com.softengine.jwttest.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Configuration
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUserName(String userName);
}
