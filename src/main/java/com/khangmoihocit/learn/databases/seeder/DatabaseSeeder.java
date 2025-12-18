package com.khangmoihocit.learn.databases.seeder;

import com.khangmoihocit.learn.modules.users.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DatabaseSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    private PasswordEncoder passwordEncoder;

    public DatabaseSeeder(){
        this.passwordEncoder = new BCryptPasswordEncoder(10);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("something seeding ...");
    }

    private boolean isTableEmpty(){
        Long count = (Long) entityManager.createQuery("select count(id) from users", User)
                .getSingleResult();
        return true;
    }
}
