package com.vinhveer.quizapp.Entity;

import com.vinhveer.quizapp.Payload.Response.QuestionIdResponse;
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
    private String image;
    private String categoryId;
    private String difficulty;
    private String createdBy;
    private List<QuestionIdResponse> questionIds;
    private String createAt;
    private String updateAt;
}
