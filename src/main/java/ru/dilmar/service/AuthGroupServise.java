package ru.dilmar.service;

import ru.dilmar.entity.AuthGroup;

import java.util.List;

public interface AuthGroupServise {
    List<AuthGroup> getListAuthGroup();

    AuthGroup getAuthGroup(int theId);

    List<AuthGroup> getListAuthGroupByName(String theAuthGroupName);

    void saveAuthGroup(AuthGroup theAuthGroup);

    void deleteAuthGroup(int theId);
}
