package com.example.bv111hospital.email.events.password;

import com.example.bv111hospital.entity.User;
import com.example.bv111hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PasswordResetListener implements
        ApplicationListener<OnPasswordResetEvent> {

    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void onApplicationEvent(OnPasswordResetEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnPasswordResetEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.createVerificationToken(user, token);

        String recipientAddress = user.getEmail();
        String subject = "Password Reset";
        String confirmationUrl
                = event.getAppUrl() + "/password_reset/" + user.getId() + "/passwordResetConfirm?token=" + token;
        String message = "Please, follow the link to confirm password reset for Hospital.";

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setFrom("46program@ukr.net");
        email.setSubject(subject);
        email.setText(message + "\r\n" + "http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }
}
