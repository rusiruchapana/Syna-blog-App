package com.rusiruchapana.Syna.blog.app.controller;

import com.rusiruchapana.Syna.blog.app.dto.PostDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @PostMapping(path = "/save")
    public PostDTO save(@RequestBody PostDTO postDTO){
        return postDTO;
    }

}
