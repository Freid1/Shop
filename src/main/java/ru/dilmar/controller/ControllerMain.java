package ru.dilmar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.dilmar.domain.AdapterUserService;
import ru.dilmar.domain.AuthGroup;
import ru.dilmar.domain.User;
import ru.dilmar.repository.AuthGroupRepository;
import ru.dilmar.repository.UsersRepository;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Collections;


@RestController
//@Controller
public class ControllerMain {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    AuthGroupRepository authGroupRepository;

    @Autowired
    AdapterUserService adapterUserService;

    @Autowired
    // @Lazy
            AuthenticationManager authenticationManager;


    @GetMapping(value = "/registration")
    public ModelAndView registration(ModelAndView modelAndView, Principal principal) {
        if (principal != null) {
            modelAndView.setViewName("index");
            modelAndView.addObject("message", "Сначало разлогинтесь чтоб зарегистрироваться");
            return modelAndView;
        }

        modelAndView.addObject("userForm", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView registrationPost(@Valid@ModelAttribute("userForm") User user, BindingResult theBindingResult, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        if (theBindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
            modelAndView.addObject("message","invalid");
            return modelAndView;
        }

        User userOld = usersRepository.findByUsername(user.getUsername());
        if (userOld != null) {
            modelAndView.setViewName("registration");
            modelAndView.addObject("message", "Пользователь с таким именем существует");
            return modelAndView;
        }
        if (user.getPassword().length() < 5 || user.getPassword() == null) {
            modelAndView.setViewName("registration");
            modelAndView.addObject("message", "Пароль должен содержать не менее 5 символов");
            return modelAndView;
        }
        String password = user.getPassword();
        String encode = new BCryptPasswordEncoder(11).encode(user.getPassword());
        user.setPassword(encode);
        user.setEnabled(true);
        usersRepository.save(user);
        AuthGroup authGroup = new AuthGroup();
        authGroup.setUsername(user.getUsername());
        authGroup.setAuthgroup("USER");
        authGroupRepository.save(authGroup);

        AuthGroup authGroup2 = new AuthGroup();
        authGroup2.setUsername(user.getUsername());
        authGroup2.setAuthgroup("ADMIN");
        authGroupRepository.save(authGroup2);

        modelAndView.addObject("message", user.getUsername());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), password, Collections.singleton(new SimpleGrantedAuthority("USER")));
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);

        modelAndView.setViewName("login-success");
        return modelAndView;
    }

    @GetMapping(value = "/login")
    public ModelAndView login(ModelAndView modelAndView, Principal principal) {
        if (principal != null) {
            modelAndView.setViewName("index");
            modelAndView.addObject("message", "Сначало разлогинтесь чтоб войти под другим именем");
            return modelAndView;
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @GetMapping(value = "/logout-success")
    public ModelAndView getLogoutPage(ModelAndView modelAndView) {
        modelAndView.setViewName("logout-success");
        return modelAndView;
    }

    @GetMapping(value = "/login-success")
    public ModelAndView loginsuccess(ModelAndView modelAndView) {
        modelAndView.setViewName("login-success");
        return modelAndView;
    }

    @GetMapping(value = "/error")
    public ModelAndView error(ModelAndView modelAndView) {
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @GetMapping(value = {"/index"})
    public ModelAndView getHomePage(ModelAndView modelAndView) {
        modelAndView.addObject("message", "Hello");
        modelAndView.setViewName("index");
        return modelAndView;
    }
 /*   @GetMapping("/")
    public ModelAndView index(Principal principal, ModelAndView modelAndView) {
        if (principal != null) {
            modelAndView.setViewName("login-success"); }
        else {modelAndView.setViewName("logout-success");}
        return modelAndView;
    }*/


}
