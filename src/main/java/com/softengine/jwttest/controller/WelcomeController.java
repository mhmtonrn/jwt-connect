package com.softengine.jwttest.controller;

import com.softengine.jwttest.entity.AuthRequest;
import com.softengine.jwttest.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WelcomeController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/test")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> testRole() {
        return ResponseEntity.ok().body("tested method");
    }

    @GetMapping("/accessDenied")
    public ResponseEntity<String> accessDenied() {
        return ResponseEntity.accepted().body("accessDenied");
    }

    @PostMapping("/auth")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
        return jwtUtil.generateToken(authRequest.getUserName());
    }

}
