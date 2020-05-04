package ru.dilmar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.dilmar.domain.User;
import ru.dilmar.repository.AuthGroupRepository;
import ru.dilmar.repository.UsersRepository;

import java.util.List;

@RestController
public class ControllerAuthAdmin {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    AuthGroupRepository authGroupRepository;

    @GetMapping("/adminpage")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ModelAndView adminpage(ModelAndView modelAndView) {
        modelAndView.setViewName("adminpage");
        return modelAndView;
    }

    @GetMapping("/edit")
    @PreAuthorize(value = "hasRole('ADMIN')")

    public ModelAndView editpage(ModelAndView modelAndView) {
        modelAndView.setViewName("editpage");
        List<User> userList = (List<User>) usersRepository.findAll();
        modelAndView.addObject("users", userList);
        return modelAndView;
    }

   /* @GetMapping("/editdel")
    @PreAuthorize(value = "hasRole('ADMIN')")
    @Transactional
    public ModelAndView editDelete(ModelAndView modelAndView, @ModelAttribute ("name")String name) {
        modelAndView.setViewName("editpage");
        System.out.println(name);
        authGroupRepository.deleteByUsername(name);
        usersRepository.deleteByUsername(name);
        return modelAndView;
    }*/

   @GetMapping("/editdel")
   @PreAuthorize(value = "hasRole('ADMIN')")
   @Transactional
   public RedirectView editDelete(ModelAndView modelAndView, @ModelAttribute ("name")String name) {
       authGroupRepository.deleteByUsername(name);
       usersRepository.deleteByUsername(name);
      return new RedirectView("edit");
      //return new ModelAndView("forward:/redirectedUrl", model);
   }
}
