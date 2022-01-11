package dev.pode.week9classactivity.controller;

import dev.pode.week9classactivity.model.Question;
import dev.pode.week9classactivity.service.QuestionService;
import dev.pode.week9classactivity.serviceimpl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class QuestionController {
    private QuestionServiceImpl service;
    private WebClient webClient;

    @Autowired
    public QuestionController(QuestionServiceImpl service, WebClient webClient) {
        this.service = service;
        this.webClient = webClient;
    }

    @PostMapping("/questions")
    public Mono<Question> createQuestion(@RequestBody Question question){
        return webClient.post()
                .uri("http://localhost:8007/questions")
                .body(Mono.just(question),Question.class)
                .retrieve()
                .bodyToMono(Question.class);
    }

    @PostMapping
    public Question saveQuestion(Question question){

        return question;
    }
}
