package com.khangmoihocit.learn.modules.users.repositories;

import com.khangmoihocit.learn.modules.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameContainingAndEmail(String name, String email);
}
