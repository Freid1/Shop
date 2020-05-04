package ru.aUdemy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.aUdemy.hibernate.entity.Color;
import ru.aUdemy.hibernate.entity.Goods;
import ru.aUdemy.hibernate.entity.Instructor;
import ru.aUdemy.hibernate.entity.InstructorDetails;

//@SpringBootApplication
public class GoGo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Goods.class)
                .buildSessionFactory();

        Session currentSession = factory.getCurrentSession();
        Goods goods = new Goods(12345, "Бодик на мальчика", "d://foto.ru", 120, 5, 15, Color.CORAL);
        currentSession.beginTransaction();
        Goods goods1 = currentSession.get(Goods.class, 1);
        System.out.println(goods1);
        currentSession.getTransaction().commit();


    }
}
