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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.dilmar.domain.AdapterUserService;
import ru.dilmar.domain.AuthGroup;
import ru.dilmar.domain.User;
import ru.dilmar.entity.Customer;
import ru.dilmar.repository.AuthGroupRepository;
import ru.dilmar.service.CustomerServise;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Collections;

@RequestMapping("/customer")
public class RegistrationAndLoginCustomer {
    @Autowired
    CustomerServise customerServise;
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
        modelAndView.addObject("customerForm", new Customer());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView registrationPost(@Valid @ModelAttribute("userForm") User user, BindingResult theBindingResult, HttpServletRequest request, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        if (principal != null) {
            modelAndView.setViewName("index");
            modelAndView.addObject("message", "Сначало разлогинтесь чтоб зарегистрироваться");
            return modelAndView;
        }


        if (theBindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
            modelAndView.addObject("message", "invalid");
            return modelAndView;
        }

        User userOld = customerServise.findByUsernameOrEmailOrPhoneNumber(user.getUsername(), user.getEmail(), user.getPhoneNumber());
        if (userOld != null) {
            modelAndView.setViewName("registration");
            if (userOld.getUsername().equals(user.getUsername())) {
                modelAndView.addObject("message", "Пользователь с таким именем существует");
            } else if (userOld.getEmail().equals(user.getEmail())) {
                modelAndView.addObject("message", "Пользователь с такиой почтой существует");
            } else {
                modelAndView.addObject("message", "Пользователь с таким телефонным номером существует");
            }
            return modelAndView;
        }
        if (user.getPassword().length() < 5 || user.getPassword() == null) {
            modelAndView.setViewName("registration");
            modelAndView.addObject("message", "Пароль должен быть больше 5 и меньше 20 символов");
            return modelAndView;
        }
        String password = user.getPassword();
        String encode = new BCryptPasswordEncoder(11).encode(user.getPassword());
        user.setPassword(encode);
        user.setEnabled(true);
        customerServise.save(user);
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


}
