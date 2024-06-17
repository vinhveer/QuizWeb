package com.vinhveer.quizapp.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BodyResponse<T> {
    private String status;
    private String message;
    private T data;
}
