package com.rusiruchapana.Syna.blog.app.controller;

import com.rusiruchapana.Syna.blog.app.dto.request.CommentRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.CommentResponseDTO;
import com.rusiruchapana.Syna.blog.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(params = "id")
    public ResponseEntity<List<CommentResponseDTO>> getAllComments(@RequestParam("id") Long postId){
        List<CommentResponseDTO> commentResponseDTO = commentService.getAllComments(postId);
        return new ResponseEntity<>(
                commentResponseDTO,
                HttpStatus.OK
        );
    }

    @GetMapping(params = {"post_id","comment_id"})
    public ResponseEntity<CommentResponseDTO> getCommentById(@RequestParam("post_id") Long postId , @RequestParam("comment_id") Long commentId){
        System.out.println("Test 1");
        CommentResponseDTO commentResponseDTO = commentService.getComment(postId , commentId);
        return new ResponseEntity<>(
                commentResponseDTO,
                HttpStatus.OK
        );
    }

    @PutMapping(params = {"post_id","comment_id"})
    public ResponseEntity<CommentResponseDTO> updateCommentById(
            @RequestParam("post_id") Long postId,
            @RequestParam("comment_id")  Long commentId,
            @RequestBody  CommentRequestDTO commentRequestDTO)
    {
        CommentResponseDTO commentResponseDTO =  commentService.updateComment(postId, commentId, commentRequestDTO);
        return new ResponseEntity<>(
                commentResponseDTO,
                HttpStatus.OK
        );
    }
}
