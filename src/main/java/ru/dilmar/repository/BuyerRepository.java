package ru.dilmar.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dilmar.domain.Buyer;

public interface BuyerRepository extends CrudRepository<Buyer,Integer> {
    public Buyer findByNameAndPassword(String name,String password);
    public Buyer findByName(String name);
}
