package ru.dilmar;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.dilmar.repository.UsersRepository;


@SpringBootApplication
//@EnableWebMvc
//@EnableJpaRepositories
public class Start {
    private static final Logger logger = LoggerFactory.getLogger(Start.class);
    public static void main(String[] args) {
        logger.info("Project ready to start");
        SpringApplication.run(Start.class, args);

    }

}
