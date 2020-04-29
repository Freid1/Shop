package ru.dilmar.repository;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.repository.CrudRepository;
import ru.dilmar.domain.User;

import java.util.List;

public interface UsersRepository extends CrudRepository<User, Integer> {
    public User findByUsername(String name);
    public User findByEmail(String name);
    public User findByPhoneNumber(String name);
    public User findByUsernameOrEmailOrPhoneNumber(String name,String email,String phoneNumber);

    public void deleteByUsername(String name);


}
