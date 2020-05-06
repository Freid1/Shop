package ru.dilmar.dao;

import ru.dilmar.entity.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(Long theId);

    void deleteCustomer(Long theId);
}
