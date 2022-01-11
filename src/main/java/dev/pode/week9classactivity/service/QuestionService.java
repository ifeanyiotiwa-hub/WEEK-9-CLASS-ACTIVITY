
        package dev.pode.week9classactivity.service;

import dev.pode.week9classactivity.model.Question;

import java.util.List;

public interface QuestionService {

    void saveQuestion(Question question);
    Question getQuestionById(Long id);
}



