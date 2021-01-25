# 🌱 springboot-webservice [![Build Status](https://travis-ci.com/Nam-Ki-Bok/springboot-webservice.svg?branch=master)](https://travis-ci.com/Nam-Ki-Bok/springboot-webservice)

**스프링 부트와 AWS로 혼자 구현하는 웹 서비스** 책을 통해 진행한 프로젝트 입니다.

구글, 네이버 로그인을 통해 게시글을 작성할 수 있는 CRUD 게시판 입니다.

📌 **[2021.01.25] Version Upgrade**

> Spring Boot 2.1.9 -> Spring Boot 2.4.1
>
> Gradle 4.10.2 -> Gradle 6.7.1
>
> Junit4 -> unit5

![화면 기록 2021-01-23 오후 8 22 40](https://user-images.githubusercontent.com/54533309/105577474-3b4c7280-5dbd-11eb-9509-963f6180f2a2.gif)

## 🛠 기술 스택

### Front-end

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://img.icons8.com/color/48/000000/html-5.png"/> <img src="https://img.icons8.com/color/48/000000/css3.png"/> <img src="https://img.icons8.com/color/48/000000/javascript-logo-1.png"/> <img src="https://user-images.githubusercontent.com/54533309/105577337-40f58880-5dbc-11eb-8aa5-24e767a38beb.png" alt="image" width="55"> <img src="https://img.icons8.com/color/48/000000/bootstrap.png"/>



### Back-end

​	**Spring boot, Spring Security, Spring Data JPA**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/54533309/105580728-66d95800-5dd1-11eb-8d5c-3d0c254ed9f3.png" alt="image" width="130">

### Build Tool

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/54533309/105578727-866a8380-5dc5-11eb-889e-67692d130c06.png" alt="image" width="140">

### Deploy with AWS

**Code Deploy**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**EC2**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**S3**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**RDS**

​	&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/54533309/105578520-3c34d280-5dc4-11eb-9cb1-716b0a766908.png" alt="AWS-CodeDeploy_dark-bg@4x" width="60">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/54533309/105578501-00017200-5dc4-11eb-8a40-ccb38fb14815.png" alt="Amazon-EC2_dark-bg@4x" width="60"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/54533309/105578510-1c9daa00-5dc4-11eb-9602-824c085953d2.png" alt="Amazon-Simple-Storage-Service-S3_dark-bg@4x" width="60">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://user-images.githubusercontent.com/54533309/105578700-5622e500-5dc5-11eb-98dc-ca596399b1d9.png" alt="Amazon-RDS_MariaDB_instance_dark-bg@4x" width="60">

### CI Tool

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://img.icons8.com/color/48/000000/travis-ci.png"/>

## 📬 CRUD API

```java
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
```

## 📚 개발 과정

#### <a href="https://nam-ki-bok.github.io/categories/Spring/" style="color:#0FA678;" target="_blank">nam-ki-bok.github.io/categories/Spring</a>

## ❗️이슈

📌 로그인을 하지 않아도 글을 열람할 수 있게 개선했다.

📌 단순히 기능만 구현한 Front-end 를 보기 좋게 개선했다.

📌 글을 작성할 때 작성자를 로그인 닉네임으로 고정하였다.

📌 자신의 글만 수정, 삭제할 수 있도록 개선했다.

📌 **Spring Security** 이해가 필요하다. 책을 통해 구현은 했지만 정확한 로직을 이해하지 못했다.

📌 **Shell** 이 익숙해지면 **Nginx** 를 통해 **CD** 도 구현해야한다.