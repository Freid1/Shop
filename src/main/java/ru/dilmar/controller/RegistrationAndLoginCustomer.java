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
import ru.dilmar.configurSecurety.AdapterCustomerDetails;
import ru.dilmar.configurSecurety.AdapterCustomerService;
import ru.dilmar.entity.AuthGroup;
import ru.dilmar.entity.Customer;
import ru.dilmar.service.AuthGroupServise;
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
    AuthGroupServise authGroupServise;

    @Autowired
    AdapterCustomerService adapterCustomerService;

    @Autowired
    // @Lazy
    AuthenticationManager authenticationManager;


    @GetMapping(value = "/registration")
    public ModelAndView registration(ModelAndView modelAndView, Principal principal) {
        if (principal != null) {
            modelAndView.setViewName("index");
            modelAndView.addObject("message", "Сначало разлогинтесь чтоб заново зарегистрироваться");
            return modelAndView;
        }
        modelAndView.addObject("customerForm", new Customer());
        modelAndView.setViewName("customer/registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView registrationPost(@Valid @ModelAttribute("customerForm") Customer customer, BindingResult theBindingResult, HttpServletRequest request, Principal principal) {
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

        Customer oldCustomer = customerServise.findByUsernameOrEmailOrPhoneNumber(customer.getName(), customer.getEmail(), customer.getPhoneNumber());
        if (oldCustomer != null) {
            modelAndView.setViewName("registration");
            if (oldCustomer.getName().equals(customer.getName())) {
                modelAndView.addObject("message", "Пользователь с таким именем существует");
            } else if (oldCustomer.getEmail().equals(customer.getEmail())) {
                modelAndView.addObject("message", "Пользователь с такиой почтой существует");
            } else {
                modelAndView.addObject("message", "Пользователь с таким телефонным номером существует");
            }
            return modelAndView;
        }
        if (customer.getPassword().length() < 1 || customer.getPassword() == null) {
            modelAndView.setViewName("registration");
            modelAndView.addObject("message", "Пароль должен быть больше 5 и меньше 20 символов");
            return modelAndView;
        }
        String password = customer.getPassword();
        String encode = new BCryptPasswordEncoder(11).encode(password);
        customer.setPassword(encode);
        customer.setEnabled(true);
        customerServise.saveCustomer(customer);
        AuthGroup authGroup = new AuthGroup();
        authGroup.setName(customer.getName());
        authGroup.setAuthgroup("USER");
        authGroupServise.saveAuthGroup(authGroup);

        AuthGroup authGroup2 = new AuthGroup();
        authGroup2.setName(customer.getName());
        authGroup2.setAuthgroup("ADMIN");
        authGroupServise.saveAuthGroup(authGroup2);

        modelAndView.addObject("messageNameCustomer", customer.getName());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(customer.getName(), password, Collections.singleton(new SimpleGrantedAuthority("USER")));
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);

        modelAndView.setViewName("index");
        return modelAndView;
    }

  /*  @GetMapping(value = "/login")
    public ModelAndView login(ModelAndView modelAndView, Principal principal) {
        if (principal != null) {
            modelAndView.setViewName("index");
            modelAndView.addObject("message", "Сначало разлогинтесь чтоб войти под другим именем");
            return modelAndView;
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
*/

}
