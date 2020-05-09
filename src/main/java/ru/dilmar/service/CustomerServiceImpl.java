package ru.dilmar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dilmar.dao.CustomerDao;
import ru.dilmar.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerServise {

    @Autowired
    private CustomerDao customerDao;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
       return customerDao.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDao.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(long theId) {
        return customerDao.getCustomer(theId);
    }

    @Override
    @Transactional
    public Customer getCustomer(String theCustomerName) {
        return customerDao.getCustomer(theCustomerName);
    }

    @Override
    @Transactional
    public void deleteCustomer(long theId) {
        customerDao.deleteCustomer(theId);
    }

    @Override
    @Transactional
    public Customer findByNameOrEmailOrPhoneNumber(String name, String email, String phoneNumber) {
        return customerDao.findByNameOrEmailOrPhoneNumber(name,email,phoneNumber);
    }
}
