package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.entity.AuthRequest;
import com.example.springsecurityjwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String helloJwt() {
        return "Hello Jwt nasilsin ?";
    }

    @PostMapping("/authentification")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        }catch (Exception exception){
            throw new Exception("Invali username or password !");
        }
        return jwtService.generateToken(authRequest.getUsername());
    }
}
