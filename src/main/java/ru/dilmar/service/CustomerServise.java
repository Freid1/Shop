package ru.dilmar.service;

import ru.dilmar.entity.Customer;

import java.util.List;

public interface CustomerServise {
    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(long theId);

    Customer getCustomer(String theCustomerName);

    void deleteCustomer(long theId);

    Customer findByNameOrEmailOrPhoneNumber(String name,String email,String phoneNumber);
}
