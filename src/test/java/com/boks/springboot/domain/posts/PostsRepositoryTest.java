package com.boks.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  // 테스트가 끝난 뒤 수행 할 메소드 지정
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void findAllPosts() {
        // given
        String title = "TEST 제목";
        String content = "TEST 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("nkb7714@gmail.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
