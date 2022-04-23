package com.softengine.jwttest.controller;

import com.softengine.jwttest.UserDTO;
import com.softengine.jwttest.entity.User;
import com.softengine.jwttest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @PostMapping("/register")
    public UserDTO saveUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return modelMapper.map(userService.saveUser(user), UserDTO.class);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{username}")
    public UserDTO getUser(@PathVariable("username") String username) {
        return modelMapper.map(userService.getUserByUsername(username),UserDTO.class);
    }
}
