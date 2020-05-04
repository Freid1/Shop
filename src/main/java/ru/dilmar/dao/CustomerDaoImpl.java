package ru.dilmar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dilmar.entity.Customer;


import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    CustomerCrudRepository customerCrudRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerCrudRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        customerCrudRepository.save(theCustomer);
    }

    @Override
    public Customer getCustomer(long theId) {
        return customerCrudRepository.findById(theId);
    }

    @Override
    public void deleteCustomer(long theId) {
        customerCrudRepository.deleteById(theId);
    }
}
