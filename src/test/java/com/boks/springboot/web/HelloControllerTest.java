package com.boks.springboot.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)  // 스프링 부트 테스트와 JUnit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class)  // 여러 스프링 테스트 어노테이션 중 web에 집중
public class HelloControllerTest {

    @Autowired  // 스프링이 관리하는 bean을 주입
    private MockMvc mvc;  // 웹 API를 테스트 하는 경우 사용, 테스트의 시작점

    @Test
    public void returnHello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  // MockMvc를 통해 /hello 주소로 GET 요청
                .andExpect(status().isOk())  // 이 요청의 상태를 검증, 이 경우 OK 즉 200 인지 확인
                .andExpect(content().string(hello));  // GET을 통해 받은 값이 hello 인지 확인
    }

    @Test
    public void returnHelloDto() throws Exception {
        String name = "test";
        int amount = 100;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}