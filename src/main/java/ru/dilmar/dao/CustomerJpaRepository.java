package ru.dilmar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.dilmar.entity.Customer;

@RepositoryRestResource(path="/members")
public interface CustomerJpaRepository extends JpaRepository<Customer,Long> {
}
