package com.example.fordleapi;

import com.example.fordleapi.user.MyUser;
import com.example.fordleapi.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FordleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FordleApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            MyUser metin = new MyUser(
                    "Metin",
                    "Demirci",
                    "metinkutay1@gmail.com",
                    "1234"

            );
            userRepository.save(metin);
        };

    }


}

