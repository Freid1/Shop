package ru.dilmar.localAndMessageSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

//@Service
public class UseMessageSource {

    MessageSource messageSource;

    @Autowired
    public UseMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void print(){
        System.out.println(messageSource);
        System.out.println(messageSource.getMessage(
                "program.name",
                new String[]{"Hello"},
               // Locale.ENGLISH));
                new Locale("ru","RU")));
    }
}
