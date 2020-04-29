package ru.dilmar.localAndMessageSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

//@Service
@PropertySource("classpath:property/test.properties")
public class PropertyAnnotation {
    @Value("${db.url}")
    String url;
    public  void print(){
        System.out.println(url);
    }
}
