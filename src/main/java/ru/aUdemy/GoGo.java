package ru.aUdemy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.aUdemy.hibernate.entity.Instructor;
import ru.aUdemy.hibernate.entity.InstructorDetails;

//@SpringBootApplication
public class GoGo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();

        Session currentSession = factory.getCurrentSession();
        InstructorDetails instructorDetails=new InstructorDetails("Sveta");
        Instructor instructor=new Instructor("Pety",instructorDetails);
        currentSession.beginTransaction();
        currentSession.save(instructor);
        currentSession.getTransaction().commit();


    }
}
