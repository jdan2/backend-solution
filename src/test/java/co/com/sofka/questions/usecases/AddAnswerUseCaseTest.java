package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Answer;
import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.AnswerDTO;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.AnswerRepository;
import co.com.sofka.questions.usecase.AddAnswerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class AddAnswerUseCaseTest {

    @SpyBean
    private AddAnswerUseCase addAnswerUseCase;

    @MockBean
    private AnswerRepository answerRepository;

    @Test
    public void addAnswerUseCase() {

        var answerDTO = new AnswerDTO("1", "1", "el huevo");
        var answer = new Answer();
        answer.setQuestionId("1");
        answer.setUserId("1");
        answer.setAnswer("el huevo");

        when(answerRepository.save(Mockito.any(Answer.class))).thenReturn(Mono.just(answer));

        var respuesta = addAnswerUseCase.añadirrespuesta(answerDTO);

        Assertions.assertEquals(respuesta.block().getAnswer(), "el huevo");


    }
}