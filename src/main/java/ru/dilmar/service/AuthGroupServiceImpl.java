package ru.dilmar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dilmar.dao.AuthGroupDao;
import ru.dilmar.entity.AuthGroup;


import java.util.List;

@Service
public class AuthGroupServiceImpl implements AuthGroupServise {

    @Autowired
    private AuthGroupDao authGroupDao;

    @Override
    @Transactional
    public List<AuthGroup> getListAuthGroup() {
        return authGroupDao.getListAuthGroup();
    }

    @Override
    @Transactional
    public List<AuthGroup> getListAuthGroupByName(String theAuthGroupName) {
        return authGroupDao.getListAuthGroupByName(theAuthGroupName);
    }

    @Override
    @Transactional
    public AuthGroup getAuthGroup(int theId) {
        return authGroupDao.getAuthGroup(theId);
    }

    @Override
    @Transactional
    public void saveAuthGroup(AuthGroup theAuthGroup) {
        authGroupDao.saveAuthGroup(theAuthGroup);
    }

    @Override
    @Transactional
    public void deleteAuthGroup(int theId) {
        authGroupDao.deleteAuthGroup(theId);
    }
}
