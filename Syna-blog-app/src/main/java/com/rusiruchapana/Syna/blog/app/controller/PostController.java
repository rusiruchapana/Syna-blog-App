package com.rusiruchapana.Syna.blog.app.controller;

import com.rusiruchapana.Syna.blog.app.dto.request.PostRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.PostResponseDTO;
import com.rusiruchapana.Syna.blog.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getAllPosts(){
        List<PostResponseDTO> postResponseDTO = postService.getAllPosts();
        return new ResponseEntity<>(
                postResponseDTO,
                HttpStatus.OK
        );
    }

    @GetMapping(params = "id")
    public ResponseEntity<PostResponseDTO> getPostById(@RequestParam("id") Long postId){
        PostResponseDTO postResponseDTO = postService.getPostById(postId);
        return new ResponseEntity<>(
                postResponseDTO,
                HttpStatus.OK
        );
    }

    @PutMapping(params = "id")
    public ResponseEntity<PostResponseDTO> updatePostById(@RequestBody PostRequestDTO postRequestDTO , @RequestParam("id") Long postId){
        PostResponseDTO postResponseDTO = postService.updatePostById(postRequestDTO , postId);
        return new ResponseEntity<>(
                postResponseDTO,
                HttpStatus.OK
        );
    }

}
