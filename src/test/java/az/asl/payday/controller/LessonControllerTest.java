package az.asl.payday.controller;

import az.asl.payday.entity.Lesson;
import az.asl.payday.model.LessonDto;
import az.asl.payday.service.lesson.LessonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
@RequiredArgsConstructor
class LessonControllerTest {


    @MockBean
    private MockMvc mockMvc;

    @Autowired
    private LessonService service;


    private ObjectMapper objectMapper;



    private static Lesson lesson;

    private static LessonDto dto;

    @BeforeAll
    static void setupAll(){
        dto = LessonDto.builder().name("asl").build();
    }



    @Test
    @DisplayName("check response")
    void getById() {



    }

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}