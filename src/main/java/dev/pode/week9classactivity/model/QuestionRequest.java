package dev.pode.week9classactivity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    private int id;
    private String title;
    private String  description;
    private String createdAt;
    private String updatedAt;
}

