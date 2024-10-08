package com.rusiruchapana.Syna.blog.app.service.impl;

import com.rusiruchapana.Syna.blog.app.dto.request.CommentRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.CommentResponseDTO;
import com.rusiruchapana.Syna.blog.app.entity.Comment;
import com.rusiruchapana.Syna.blog.app.entity.Post;
import com.rusiruchapana.Syna.blog.app.exception.BlogApiException;
import com.rusiruchapana.Syna.blog.app.exception.ResourceNotFoundException;
import com.rusiruchapana.Syna.blog.app.repository.CommentRepository;
import com.rusiruchapana.Syna.blog.app.repository.PostRepository;
import com.rusiruchapana.Syna.blog.app.service.CommentService;
import com.rusiruchapana.Syna.blog.app.util.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private PostRepository postRepository;

    @Override
    public CommentResponseDTO createComment(Long postId, CommentRequestDTO commentRequestDTO) {

        Comment comment = commentMapper.dtoToEntity(commentRequestDTO);
        Optional<Post> post = postRepository.findById(postId);

        if(post.isPresent()){
            comment.setPost(post.get());
            commentRepository.save(comment);

            CommentResponseDTO commentResponseDTO = commentMapper.entityToDto(comment);
            return commentResponseDTO;
        }else {
            throw new ResourceNotFoundException("Comment", "id", Long.toString(postId));
        }
    }

    @Override
    public List<CommentResponseDTO> getAllComments(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        List<CommentResponseDTO> commentResponseDTOS = commentMapper.entityToDto(comments);
        return commentResponseDTOS;
    }

    @Override
    public CommentResponseDTO getComment(Long postId, Long commentId) {

        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","id",Long.toString(postId)));
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new  ResourceNotFoundException("Comment","id",Long.toString(commentId)));

        if(comment.getPost().getId() == post.getId()){
            return commentMapper.entityToDto(comment);
        }else {
            throw new BlogApiException(HttpStatus.BAD_REQUEST , "Comment not exist.");
        }
    }

    @Override
    public CommentResponseDTO updateComment(Long postId, Long commentId, CommentRequestDTO commentRequestDTO) {

        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", Long.toString(postId)));
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "id", Long.toString(commentId)));

        if(comment.getPost().getId().equals(post.getId())){
            comment.setName(commentRequestDTO.getName());
            comment.setEmail(commentRequestDTO.getEmail());
            comment.setBody(commentRequestDTO.getBody());

            commentRepository.save(comment);
            CommentResponseDTO commentResponseDTO = commentMapper.entityToDto(comment);
            return commentResponseDTO;
        }else {
            throw new BlogApiException(HttpStatus.BAD_REQUEST , "Comment is not exist in the post.");
        }
    }

    @Override
    public String deleteComment(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", Long.toString(postId)));
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "id", Long.toString(commentId)));
        if(comment.getPost().getId().equals(post.getId())){
            commentRepository.deleteById(commentId);
            return "Sucessfully deleted comment";
        }else {
            throw new BlogApiException(HttpStatus.BAD_REQUEST , "Comment is not exist in the post.");
        }
    }


}
