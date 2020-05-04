package ru.dilmar.service;

import ru.dilmar.entity.Customer;

import java.util.List;

public interface CustomerServise {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(long theId);

    public void deleteCustomer(long theId);
}
