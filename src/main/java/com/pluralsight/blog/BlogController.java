package com.pluralsight.blog;

import java.util.List;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

    private PostRepository postRepository;

    BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping("/")
    public String listPosts(ModelMap modelMap) {

        List<Post> posts = postRepository.getAllPosts();

        System.out.println(posts.get(0).getTitle());
        
        modelMap.put("posts", posts);
        return "home";
    }

}
