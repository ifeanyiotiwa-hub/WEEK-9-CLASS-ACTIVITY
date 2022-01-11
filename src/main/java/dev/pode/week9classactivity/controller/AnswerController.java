package dev.pode.week9classactivity.controller;

import dev.pode.week9classactivity.model.Answer;
import dev.pode.week9classactivity.model.Question;
import dev.pode.week9classactivity.serviceimpl.AnswerServiceImpl;
import dev.pode.week9classactivity.serviceimpl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class AnswerController {

    private AnswerServiceImpl service;
    private WebClient webClient;
    private WebClient.Builder builder;

    @Autowired
    public AnswerController(AnswerServiceImpl service, WebClient webClient, WebClient.Builder builder) {
        this.service = service;
        this.webClient = webClient;
        this.builder = builder;
    }

    @PostMapping("/questions/{questionId}/answers")
    public Mono<Answer> createAnswer(@RequestBody Answer answer, @PathVariable Long questionId){
        return webClient.post()
                .uri("http://localhost:8007/questions/{" + questionId +"}/answers")
                .body(Mono.just(answer),Answer.class)
                .retrieve()
                .bodyToMono(Answer.class);
    }

    @GetMapping("/questions/{questionId}/answers")
    public Answer getAnswerById( @PathVariable Long questionId){

        Answer subject = builder.build()
                .get()
                .uri("http://localhost:8007/questions/" + questionId+ "/answers")
                .retrieve()
                .bodyToMono(Answer.class)
                .block();


        return subject;
    }
}
