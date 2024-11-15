package com.vocaciON.vocacion_service.repository;

import com.vocaciON.vocacion_service.model.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {


    Optional<PasswordResetToken> findByToken(String token);
}
