package ru.dilmar.repository;


import org.springframework.data.repository.CrudRepository;
import ru.dilmar.domain.User;

import java.util.List;

public interface UsersRepository extends CrudRepository<User, Integer> {
    public User findByUsername(String name);
public  void deleteByUsername(String name);


}
