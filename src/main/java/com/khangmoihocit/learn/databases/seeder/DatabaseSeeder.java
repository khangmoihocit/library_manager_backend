package com.khangmoihocit.learn.databases.seeder;

import com.khangmoihocit.learn.modules.users.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//init database
@Component
public class DatabaseSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if(isTableEmpty()){
            String passwordEncode = passwordEncoder.encode("password");
            entityManager.createNativeQuery("insert into users(user_catalogue_id, name, email, password, phone) values (?, ?, ?, ?, ?)")
                    .setParameter(1, 1)
                    .setParameter(3, "khang567.ht@gmail.com")
                    .setParameter(2, "Pham Van Khang")
                    .setParameter(4, passwordEncode)
                    .setParameter(5, "09876652")
                    .executeUpdate();
        }
    }

    private boolean isTableEmpty(){
        Long count = (Long) entityManager.createQuery("select count(id) from User").getSingleResult();
        return count == 0;
    }
}
