package ru.dilmar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.dilmar.entity.Customer;

import java.util.List;

public interface CustomerCrudRepository extends CrudRepository<Customer,Long> {
    public List<Customer> findAll();
    public Customer findById(long id);
    public void deleteById(long id);

}
