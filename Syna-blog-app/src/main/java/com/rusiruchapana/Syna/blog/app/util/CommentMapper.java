package com.rusiruchapana.Syna.blog.app.util;

import com.rusiruchapana.Syna.blog.app.dto.request.CommentRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.request.PostRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.CommentResponseDTO;
import com.rusiruchapana.Syna.blog.app.entity.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment dtoToEntity(CommentRequestDTO commentRequestDTO);
    CommentResponseDTO entityToDto(Comment comment);
    List<CommentResponseDTO> entityToDto(List<Comment> comments);
}
