package ru.dilmar.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

@RestController
public class ControllerAuthUser {



    @GetMapping("/userpage")
    @PreAuthorize(value = "hasRole('USER')")
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.setViewName("userpage");
        return modelAndView;
    }

    @GetMapping("/goods")
    @PreAuthorize(value = "hasRole('USER')")
    public ModelAndView goods(ModelAndView modelAndView) {
       /* Properties properties = System.getProperties();
        String path =(String) properties.get("user.dir");
        String fullPath=path+"\\src\\main\\resources\\static\\photoGoods";*/

        File file=new File("src\\main\\resources\\static\\fotoGoods");
        String[] strings = file.list();
        ArrayList<String> arrayList=new ArrayList<>();
        for (String string : strings) {
            arrayList.add(new String("../fotoGoods/"+string));
        }
        modelAndView.addObject("pathGoods", arrayList);
        modelAndView.setViewName("goods");
        return modelAndView;
    }
}

