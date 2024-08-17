package com.rusiruchapana.Syna.blog.app.controller;

import com.rusiruchapana.Syna.blog.app.dto.request.PostRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.PaginatedPostResponseDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.PostResponseDTO;
import com.rusiruchapana.Syna.blog.app.service.PostService;
import jakarta.validation.Valid;
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
    public ResponseEntity<PostResponseDTO> createPost(@Valid @RequestBody PostRequestDTO postRequestDTO){
        PostResponseDTO postResponseDTO = postService.createPost(postRequestDTO);
        return new ResponseEntity<>(
                postResponseDTO,
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<PaginatedPostResponseDTO> getAllPosts(
            @RequestParam(value = "no", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "size", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "sort", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String dir
    )
    {
        PaginatedPostResponseDTO paginatedPostResponseDTO = postService.getAllPosts(pageNo , pageSize, sortBy, dir);
        return new ResponseEntity<>(
                paginatedPostResponseDTO,
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
    public ResponseEntity<PostResponseDTO> updatePostById(@Valid @RequestBody PostRequestDTO postRequestDTO , @RequestParam("id") Long postId){
        PostResponseDTO postResponseDTO = postService.updatePostById(postRequestDTO , postId);
        return new ResponseEntity<>(
                postResponseDTO,
                HttpStatus.OK
        );
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String> deletePost(@RequestParam("id") Long postId){
        String msg = postService.deletePostById(postId);
        return new ResponseEntity<>(
                msg,
                HttpStatus.OK
        );
    }

}
