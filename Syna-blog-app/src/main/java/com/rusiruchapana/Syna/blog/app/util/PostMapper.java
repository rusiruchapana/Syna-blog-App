package com.rusiruchapana.Syna.blog.app.util;

import com.rusiruchapana.Syna.blog.app.dto.request.PostRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.PostResponseDTO;
import com.rusiruchapana.Syna.blog.app.entity.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post dtoToEntity(PostRequestDTO postRequestDTO);
    PostResponseDTO entityToDto(Post post);
    List<PostResponseDTO> entityToDto(List<Post> posts);
}
