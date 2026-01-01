package com.khangmoihocit.learn.modules.users.repositories;

import com.khangmoihocit.learn.modules.users.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    boolean existByRefreshToken(String refreshToken);
    Optional<RefreshToken> findByRefreshToken(String tokenToken);
}
