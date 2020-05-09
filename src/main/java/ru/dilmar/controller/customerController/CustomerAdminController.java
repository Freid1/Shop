package ru.dilmar.controller.customerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.dilmar.entity.Customer;
import ru.dilmar.service.CustomerServise;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CustomerAdminController{
    @Autowired
    CustomerServise customerServise;

    @GetMapping("/customers")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ModelAndView getCustomers() {
        ModelAndView modelAndView =new ModelAndView();
        Customer customer=new Customer();
        customer.setEnabled(true);
        List<Customer> listCustomers = customerServise.getCustomers();
        modelAndView.addObject("allCustomers", listCustomers);
        modelAndView.addObject("customer", customer);
        modelAndView.setViewName("admin/editcustomers");
        return modelAndView;
    }

    @GetMapping("/customers/{customerId}")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ModelAndView getCustomer(@PathVariable long customerId) {
        ModelAndView modelAndView =new ModelAndView();
        Customer theCustomer = customerServise.getCustomer(customerId);
        if (theCustomer == null) {
            throw new CustomerRestException("Customer id not found - " + customerId);
        }
        modelAndView.addObject("allCustomers", theCustomer);
        modelAndView.setViewName("admin/editcustomers");
        return modelAndView;
    }

    @PostMapping("/customers")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ModelAndView postCustomer(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
        ModelAndView modelAndView =new ModelAndView();

        if (theBindingResult.hasErrors()) {
            modelAndView.setViewName("admin/editcustomers");
            return modelAndView;
        }

        customerServise.saveCustomer(theCustomer);
        modelAndView.setViewName("redirect:/admin/customers");
        return modelAndView;
    }

    @PutMapping("/customers")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ModelAndView putCustomer(@RequestBody Customer theCustomer) {
        ModelAndView modelAndView =new ModelAndView();
        customerServise.saveCustomer(theCustomer);
        modelAndView.setViewName("redirect:/admin/customers");
        return modelAndView;
    }

    @DeleteMapping("/customers/{id}")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ModelAndView deleteCustomer(@PathVariable(name = "id") long customerId) {
        System.out.println("delete id =" + customerId);
        ModelAndView modelAndView =new ModelAndView();
        customerServise.deleteCustomer(customerId);
        modelAndView.setViewName("redirect:/admin/customers");
        return modelAndView;
    }

}
