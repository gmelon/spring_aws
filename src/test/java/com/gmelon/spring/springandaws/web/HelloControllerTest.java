package com.gmelon.spring.springandaws.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 스프링 부트와 JUnit 사이의 연결자
@WebMvcTest(controllers = HelloController.class) // Spring MVC에만 집중하도록 하는 테스트 어노테이션(?)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; // 스프링 MVC 테스트의 시작점, 웹 API를 테스트할 때 사용함

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // HTTP GET 요청
            .andExpect(status().isOk()) // status 검증
            .andExpect((content().string(hello))); // content(응답 본문 내용) 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
            .andExpect(status().isOk()) // status 검증
            .andExpect(jsonPath("$.name", is(name)))
            .andExpect(jsonPath("$.amount", is(amount))); // content(응답 본문 내용) 검증
    }

}