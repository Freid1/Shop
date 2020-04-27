package ru.dilmar.property;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "ru.dilmar.property")
public class StartProperty {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(StartProperty.class);
        PropertyTest propertyTest=(PropertyTest) ctx.getBean("property");
        propertyTest.print();

    }
}
