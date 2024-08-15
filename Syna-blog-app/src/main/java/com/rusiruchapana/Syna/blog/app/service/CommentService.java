package com.rusiruchapana.Syna.blog.app.service;

import com.rusiruchapana.Syna.blog.app.dto.request.CommentRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.CommentResponseDTO;

public interface CommentService {
    CommentResponseDTO createComment(Long postId, CommentRequestDTO commentRequestDTO);
}
