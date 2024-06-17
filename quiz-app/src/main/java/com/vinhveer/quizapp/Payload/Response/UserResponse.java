package com.vinhveer.quizapp.Payload.Response;

import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String username;
    private String email;
    private String avatar;
    private String createAt;
    private String updateAt;
}
