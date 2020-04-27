package ru.dilmar.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:property/test.properties")
public class PropertyTest {
    @Value("${db.url}")
    String url;

    public  void print(){
        System.out.println(url);
    }
}
