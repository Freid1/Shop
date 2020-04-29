package ru.dilmar.controller;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class test {
    public static void main(String[] args) throws IOException {
File file=new File("src\\main\\resources\\static\\photoGoods");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getCanonicalPath());


        Properties properties = System.getProperties();
        String path =(String) properties.get("user.dir");
        String fullPath=path+"\\src\\main\\resources\\static\\photoGoods";
        System.out.println(fullPath);



    }
}
