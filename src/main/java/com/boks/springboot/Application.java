package com.boks.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성 모두 자동 설정
// 이 Annotation 부터 설정을 읽기 때문에 이 클래스는 항상 프로젝트 최상단에 있어야 함
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}