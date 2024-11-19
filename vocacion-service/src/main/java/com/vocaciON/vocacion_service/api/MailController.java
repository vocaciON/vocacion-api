package com.vocaciON.vocacion_service.api;


import com.vocaciON.vocacion_service.service.PasswordResetTokenService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailController {

    private final PasswordResetTokenService passwordResetTokenService;


    @PostMapping("/sendMail")
    public ResponseEntity<Void> sendPasswordResetMail(@RequestBody String email) throws Exception{
        passwordResetTokenService.createAndSendPasswordResetToken(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/reset/check/{token}")
    public ResponseEntity<Boolean> checkTokenValidity(@PathVariable("token")String token){
        boolean isValid = passwordResetTokenService.isValidToken(token);
        return new ResponseEntity<>(isValid, HttpStatus.OK);
    }

    //restblecer la conttraseña usando el token
    @PostMapping("/reset/{token}")
    public ResponseEntity<Void> resetPassword(@PathVariable("token")String token, @RequestBody String newPassword) {
        passwordResetTokenService.resetPassword(token, newPassword);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
