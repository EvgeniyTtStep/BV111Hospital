package com.example.bv111hospital.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

@Getter
@Setter
@Entity
@Component
@Table(name = "verification_token")
public class VerificationToken {
    private static final int EXPIRATION = 60 * 24;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "date")
    private Date expiryDate;

    private Date calcExpiryDate(int expiryTimeInMinutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(calendar.getTime().getTime()));
        calendar.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(calendar.getTime().getTime());
    }

    public VerificationToken() {
    }

    public VerificationToken(String token, Long uid) {
        this.token = token;
        this.userId = uid;
        this.expiryDate = calcExpiryDate(EXPIRATION);
    }

}
