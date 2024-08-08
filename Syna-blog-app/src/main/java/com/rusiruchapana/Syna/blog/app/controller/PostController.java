package com.rusiruchapana.Syna.blog.app.controller;

import com.rusiruchapana.Syna.blog.app.dto.PostDTO;
import com.rusiruchapana.Syna.blog.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(path = "/greeting")
    public void greeting(){
        System.out.println("Rusiru");
    }

    @PostMapping(path = "/create-post")
    public PostDTO createPost(@RequestBody PostDTO postDTO){
        System.out.println("Test");
        return postDTO;
    }


}
