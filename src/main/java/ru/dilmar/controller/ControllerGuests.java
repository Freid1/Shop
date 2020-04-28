package ru.dilmar.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.jsf.FacesContextUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.ManagedBean;
import java.io.File;
import java.util.ArrayList;


@RestController
@RequestMapping("/guest")
public class ControllerGuests {

    @GetMapping("/gallery")
    public ModelAndView guestGallery(ModelAndView modelAndView) {
        File file=new File("src\\main\\resources\\static\\guest\\foto");
        String[] strings = file.list();
        ArrayList<String> arrayList=new ArrayList<>();
        for (String string : strings) {
            arrayList.add(new String("../guest/foto/"+string));
        }
        modelAndView.addObject("pathGalleryFoto", arrayList);
        modelAndView.setViewName("gallery");
        return modelAndView;
    }
}
