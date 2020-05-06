package ru.dilmar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.dilmar.entity.Customer;
import ru.dilmar.service.CustomerServise;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class ControllerCustomer {
    @Autowired
    CustomerServise customerServise;

    @GetMapping("/customers")
  //  @PreAuthorize(value = "hasRole('ADMIN')")
    public ModelAndView getCustomers(ModelAndView modelAndView) {
        List<Customer> listCustomers=customerServise.getCustomers();
       modelAndView.addObject("allCustomers",listCustomers);
       modelAndView.setViewName("admin/editcustomers");
        return modelAndView;
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable long customerId) {
        Customer theCustomer = customerServise.getCustomer(customerId);

     /*   if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }*/

        return theCustomer;
    }

    @PostMapping("/customers")
    public Customer postCustomer(@RequestBody Customer theCustomer) {
        customerServise.saveCustomer(theCustomer);
        return theCustomer;
    }

    @PutMapping("/customers")
    public Customer putCustomer(@RequestBody Customer theCustomer) {
       customerServise.saveCustomer(theCustomer);
       return theCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public ModelAndView  deleteCustomer(@PathVariable long customerId, ModelAndView modelAndView) {
        customerServise.deleteCustomer(customerId);
        modelAndView.setViewName("/v1/customers");
        return modelAndView;
    }

}
