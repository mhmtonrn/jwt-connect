package com.softengine.jwttest.service;

import com.softengine.jwttest.entity.Privilege;
import com.softengine.jwttest.entity.Role;
import com.softengine.jwttest.entity.User;
import com.softengine.jwttest.repository.PrivilegeRepository;
import com.softengine.jwttest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PrivilegeRepository privilegeRepository;

    public boolean isUserExist(String username) {
        Optional<User> user = userRepository.findByUserName(username);
        return user.isPresent();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public User saveUser(User user) {
        Role r2 = new Role();
        r2.setId(2);
        r2.setName("USER");
        r2.setDesci("USER");
        User savedUser = userRepository.save(user);
        Privilege privilege = new Privilege();
        privilege.setUser(savedUser);
        privilege.setRole(r2);
        privilegeRepository.save(privilege);
        return savedUser;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }





}
