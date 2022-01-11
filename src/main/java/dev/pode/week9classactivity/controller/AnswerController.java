package dev.pode.week9classactivity.controller;

import dev.pode.week9classactivity.model.Answer;
import dev.pode.week9classactivity.model.Question;
import dev.pode.week9classactivity.serviceimpl.AnswerServiceImpl;
import dev.pode.week9classactivity.serviceimpl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class AnswerController {

    private AnswerServiceImpl service;
    private WebClient webClient;

    @Autowired
    public AnswerController(AnswerServiceImpl service, WebClient webClient) {
        this.service = service;
        this.webClient = webClient;
    }

    @PostMapping("/questions/{questionId}/answers")
    public Mono<Answer> createAnswer(@RequestBody Answer answer, @PathVariable Long questionId){
        return webClient.post()
                .uri("http://localhost:8007/questions")
                .body(Mono.just(answer),Answer.class)
                .retrieve()
                .bodyToMono(Answer.class);
    }
}
