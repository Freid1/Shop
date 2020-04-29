package ru.aUdemy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.aUdemy.hibernate.entity.Instructor;

//@SpringBootApplication
public class GoGo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session currentSession = factory.getCurrentSession();
        Instructor instructor=new Instructor();
        instructor.setName("Pety");
        currentSession.beginTransaction();
        currentSession.save(instructor);
        currentSession.getTransaction().commit();


    }
}
