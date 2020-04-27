package ru.dilmar.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dilmar.domain.AuthGroup;

import java.util.List;

public interface AuthGroupRepository extends CrudRepository<AuthGroup,Integer> {
    List<AuthGroup> findByUsername(String username);
    public void deleteByUsername(String name);

}
