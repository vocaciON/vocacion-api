package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.exception.ResourceNotFoundException;
import com.vocaciON.vocacion_service.integration.notificacion.email.dto.Mail;
import com.vocaciON.vocacion_service.integration.notificacion.email.service.EmailService;
import com.vocaciON.vocacion_service.model.entity.PasswordResetToken;
import com.vocaciON.vocacion_service.model.entity.Usuario;
import com.vocaciON.vocacion_service.repository.PasswordResetTokenRepository;
import com.vocaciON.vocacion_service.repository.UsuarioRepository;
import com.vocaciON.vocacion_service.service.PasswordResetTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmailService emailService;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @Transactional
    @Override
    public void createAndSendPasswordResetToken(String email) throws Exception {
        Usuario usuario = usuarioRepository.findByEmail(email).
                orElseThrow(() -> new Exception("Usuario no encontrado"));

        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setToken(UUID.randomUUID().toString());
        passwordResetToken.setUsuario(usuario);
        passwordResetToken.setExpiration(10);
        passwordResetTokenRepository.save(passwordResetToken);


        Map<String, Object> model = new HashMap<>();
        String resetUrl = "http://localhost:4200/#/forgot"+passwordResetToken.getToken();
        model.put("usuario", usuario.getEmail());
        model.put("resetUrl", resetUrl);

        Mail mail = emailService.createMail(
                usuario.getEmail(),
                "Restablecer Contraseña",
                model,
                mailFrom
        );

        emailService.sendEmail(mail,"email/password-reset-template");

    }

    @Override
    public PasswordResetToken findByToken(String token) {
        return passwordResetTokenRepository.findByToken(token)
                .orElseThrow(()-> new ResourceNotFoundException("Token de restablecimiento de contraseña no encontrado"));

    }

    @Override
    public boolean isValidToken(String token) {
        return passwordResetTokenRepository.findByToken(token).filter(t->!t.isExpired()).isPresent();
    }

    @Override
    public void removeResetToken(PasswordResetToken passwordResetToken) {
        passwordResetTokenRepository.delete(passwordResetToken);

    }

    @Override
    public void resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = passwordResetTokenRepository.findByToken(token)
                .filter(t->!t.isExpired())
                .orElseThrow(()-> new ResourceNotFoundException("Token invalido o expirado"));

        Usuario usuario = resetToken.getUsuario();
        usuario.setPassword(newPassword);

        usuarioRepository.save(usuario);

        passwordResetTokenRepository.delete(resetToken);

    }
}
