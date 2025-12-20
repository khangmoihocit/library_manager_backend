package com.khangmoihocit.learn.databases.seeder;

import com.khangmoihocit.learn.modules.users.entities.User;
import com.khangmoihocit.learn.modules.users.repositories.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if(isTableEmpty()){
            String passwordEncode = passwordEncoder.encode("password");
            User user = User.builder()
                    .user_catalogue_id(Long.valueOf(1))
                    .name("Pham Van Khang")
                    .email("khang567.ht@gmail.com")
                    .password(passwordEncode)
                    .phone("0987654321")
                    .build();
            userRepository.save(user);
        }
    }

    private boolean isTableEmpty(){
        Long count = (Long) entityManager.createQuery("select count(id) from User").getSingleResult();
        return count == 0;
    }
}
