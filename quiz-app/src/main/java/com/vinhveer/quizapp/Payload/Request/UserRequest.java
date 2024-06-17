package com.vinhveer.quizapp.Payload.Request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String email;
    private String password;
    private String avatar;
}
