package ru.dilmar.bundleSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class BundleBean {
    MessageSource messageSource;

    @Autowired
    public BundleBean( MessageSource messageSource) {
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
