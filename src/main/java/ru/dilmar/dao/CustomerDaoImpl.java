package ru.dilmar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dilmar.entity.Customer;


import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    CustomerJpaRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long theId) {
        return customerRepository.getOne(theId);
    }

    @Override
    public Customer getCustomer(String theCustomerName) {
        return customerRepository.findByName(theCustomerName);
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    public void deleteCustomer(Long theId) {              customerRepository.deleteById(theId);    }

    @Override
    public Customer findByUsernameOrEmailOrPhoneNumber(String name, String email, String phoneNumber) {
        return customerRepository.findByUsernameOrEmailOrPhoneNumber(name,email,phoneNumber);
    }




}
