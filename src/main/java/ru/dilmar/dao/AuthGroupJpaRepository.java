package ru.dilmar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dilmar.entity.AuthGroup;

import java.util.List;

public interface AuthGroupJpaRepository extends JpaRepository<AuthGroup, Integer> {
    List<AuthGroup> findByName(String authGroupName);
}
