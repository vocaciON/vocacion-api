package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.PasswordResetToken;

public interface PasswordResetTokenService {

    void createAndSendPasswordResetToken(String email) throws Exception;

    PasswordResetToken findByToken(String token);

    void removeResetToken(PasswordResetToken passwordResetToken);

    void resetPassword(String token, String newPassword);

    boolean isValidToken(String token);
}
