package ru.dilmar;


<<<<<<< HEAD
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> bf4d83a9a07dfb3a57a09e5f10fae603ed63e8d3
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
<<<<<<< HEAD

    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
=======
    private static final Logger logger = LoggerFactory.getLogger(Start.class);
    public static void main(String[] args) {
        logger.info("Project ready to start");
        SpringApplication.run(Start.class, args);

>>>>>>> bf4d83a9a07dfb3a57a09e5f10fae603ed63e8d3
    }

}
