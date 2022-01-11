package dev.pode.week9classactivity.serviceimpl;

import dev.pode.week9classactivity.model.Question;
import dev.pode.week9classactivity.repository.QuestionRepository;
import dev.pode.week9classactivity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository repository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveQuestion(Question question) {
        repository.saveQuestion(question);

    }

    @Override
    public Question getQuestionById(Long id) {
        return null;
    }
}