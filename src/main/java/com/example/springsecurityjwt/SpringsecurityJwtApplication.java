package com.example.springsecurityjwt;

import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringsecurityJwtApplication {

    private final UserRepository userRepository;

    public void createUsers() {
        List<User> list = Stream.of(
                new User(1, "rufet", "12345", "huseyn@gmail.com"),
                new User(1, "alsu", "123456", "alsu@gmail.com"),
                new User(1, "sebnem", "1234567", "sebnem@gmail.com"),
                new User(1, "ugur", "12345678", "ugur@gmail.com")
        ).collect(Collectors.toList());

        userRepository.saveAll(list);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityJwtApplication.class, args);
    }

}
