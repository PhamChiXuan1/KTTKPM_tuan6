package com.example.restuser;

import com.example.restuser.model.User;
import com.example.restuser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestUserApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

//    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            for (int i = 0; i < 5; i++) {
                User user = new User("name " + i);
                userRepository.save(user);
            }
        };
    }
}
