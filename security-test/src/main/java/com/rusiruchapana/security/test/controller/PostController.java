package com.rusiruchapana.security.test.controller;

import com.rusiruchapana.security.test.dto.request.PostRequestDTO;
import com.rusiruchapana.security.test.dto.response.PostResponseDTO;
import com.rusiruchapana.security.test.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/post")
public class PostController {

    @Autowired
    private PostService postService;
    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostRequestDTO postRequestDTO){
        PostResponseDTO postResponseDTO = postService.createPost(postRequestDTO);
        return new ResponseEntity<>(
                postResponseDTO,
                HttpStatus.CREATED
        );
    }

    


}
