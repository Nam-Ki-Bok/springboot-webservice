package com.boks.springboot.web;

import com.boks.springboot.config.auth.LoginUser;
import com.boks.springboot.config.auth.dto.SessionUser;
import com.boks.springboot.service.posts.PostsService;
import com.boks.springboot.web.dto.PostsResponseDto;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user) {
        model.addAttribute("userName", user.getName());
        return "posts-save";
    }

    @GetMapping("/posts/view/{id}")
    public String postsView(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        PostsResponseDto dto = postsService.findById(id);

        if (dto.getAuthor().equals(user.getName())) {
            model.addAttribute("checkMyPost", true);
        }

        else {
            model.addAttribute("checkMyPost", false);
        }

        model.addAttribute("post", dto);

        return "posts-view";
    }

    @GetMapping("posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}