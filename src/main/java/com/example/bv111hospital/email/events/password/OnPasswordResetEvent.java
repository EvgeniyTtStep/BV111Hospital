package com.example.bv111hospital.email.events.password;

import com.example.bv111hospital.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

@Getter
@Setter
public class OnPasswordResetEvent extends ApplicationEvent {
    private String appUrl;
    private Locale locale;
    private User user;

    public OnPasswordResetEvent(
            User user, Locale locale, String appUrl) {
        super(user);
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }

}