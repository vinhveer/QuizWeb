package com.vinhveer.quizappbe.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BodyResponse<T> {
    private boolean status;
    private String message;
    private T response;
}
