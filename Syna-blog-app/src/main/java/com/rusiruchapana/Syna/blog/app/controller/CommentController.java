package com.rusiruchapana.Syna.blog.app.controller;

import com.rusiruchapana.Syna.blog.app.dto.request.CommentRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.CommentResponseDTO;
import com.rusiruchapana.Syna.blog.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(params = "id")
    public ResponseEntity<CommentResponseDTO> createComment(@RequestParam("id") Long postId , @RequestBody CommentRequestDTO commentRequestDTO){

        CommentResponseDTO commentResponseDTO = commentService.createComment(postId , commentRequestDTO);
        return new ResponseEntity<>(
                commentResponseDTO,
                HttpStatus.CREATED
        );
    }
}
