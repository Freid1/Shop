package ru.aUdemy.hibernate.entity.aUdemy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.aUdemy.hibernate.entity.aUdemy.hibernate.entity.Instructor;

//@SpringBootApplication
public class Start {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session currentSession = factory.getCurrentSession();
        System.out.println(currentSession);

    }
}
