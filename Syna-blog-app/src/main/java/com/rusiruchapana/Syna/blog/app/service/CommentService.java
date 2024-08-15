package com.rusiruchapana.Syna.blog.app.service;

import com.rusiruchapana.Syna.blog.app.dto.request.CommentRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.CommentResponseDTO;

import java.util.List;

public interface CommentService {
    CommentResponseDTO createComment(Long postId, CommentRequestDTO commentRequestDTO);
    List<CommentResponseDTO> getAllComments(Long postId);

    CommentResponseDTO getComment(Long postId, Long commentId);
}
