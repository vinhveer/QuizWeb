package com.vinhveer.quizappbe.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Results {
    @Id
    private String id;
    private String quizId;
    private String userId;
    private int score;
    private String totalQuestions;
    private String correctAnswers;
    private String takenAt;
}
