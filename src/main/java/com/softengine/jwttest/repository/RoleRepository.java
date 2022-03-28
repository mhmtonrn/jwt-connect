package com.softengine.jwttest.repository;

import com.softengine.jwttest.entity.Role;
import com.softengine.jwttest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    List<Role> findByName(String userName);
}
