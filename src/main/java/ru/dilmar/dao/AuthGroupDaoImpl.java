package ru.dilmar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dilmar.entity.AuthGroup;

import java.util.List;

@Repository
public class AuthGroupDaoImpl implements AuthGroupDao {

    @Autowired
    AuthGroupJpaRepository repository;


    @Override
    public List<AuthGroup> getListAuthGroup() {

        return repository.findAll();
    }

    @Override
    public void saveAuthGroup(AuthGroup theAuthGroup) {
        repository.save(theAuthGroup);
    }

    @Override
    public AuthGroup getAuthGroup(int theId) {
        return repository.getOne(theId);
    }

    @Override
    public List<AuthGroup> getListAuthGroupByName(String theAuthGroupName) {
        return repository.findByName(theAuthGroupName);
    }

    @Override
    public void deleteAuthGroup(int theId) {
        repository.deleteById(theId);
    }
}
