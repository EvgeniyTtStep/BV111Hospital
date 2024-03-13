package com.example.bv111hospital.security.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class JwtTokenSuccessResponse {

    private boolean success;

    private String token;

}
