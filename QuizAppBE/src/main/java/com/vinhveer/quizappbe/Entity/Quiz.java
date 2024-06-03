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
public class Quiz {
    @Id
    private String id;
    private String title;
    private String description;
    private String category;
    private String difficulty;
    private String createdBy;
    private List<Question> questions;
    private String createAt;
    private String updateAt;
}
