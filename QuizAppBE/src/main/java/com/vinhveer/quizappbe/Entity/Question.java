package com.vinhveer.quizappbe.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    private String id;
    private String quizId;
    private String questionText;
    private String questionImage;
    private List<Option> options;
    private String createAt;
    private String updateAt;
}
