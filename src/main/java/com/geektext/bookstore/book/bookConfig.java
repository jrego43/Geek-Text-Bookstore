package com.geektext.bookstore.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class bookConfig {
    @Bean
    CommandLineRunner commandLineRunner(bookRepository bRepository){
        return args -> {

        };
    }
}
