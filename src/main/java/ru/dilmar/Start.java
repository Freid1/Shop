package ru.dilmar;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
//@EnableWebMvc
//@EnableJpaRepositories
public class Start {


    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);

    }

}
