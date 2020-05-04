package ru.dilmar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.dilmar.entity.Customer;
import ru.dilmar.service.CustomerServise;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class ControllerCustomer {
    @Autowired
    CustomerServise customerServise;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {

        return customerServise.getCustomers();

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
    public String  deleteCustomer(@PathVariable long customerId) {
        customerServise.deleteCustomer(customerId);
        return "Delete customer "+customerId;
    }

}
