package ru.dilmar.dao;

import ru.dilmar.entity.AuthGroup;

import java.util.List;


public interface AuthGroupDao {
    List<AuthGroup> getListAuthGroup();

    List<AuthGroup> getListAuthGroupByName(String theAuthGroupName);

    void saveAuthGroup(AuthGroup theAuthGroup);

    AuthGroup getAuthGroup(int theId);

    void deleteAuthGroup(int theId);
}
