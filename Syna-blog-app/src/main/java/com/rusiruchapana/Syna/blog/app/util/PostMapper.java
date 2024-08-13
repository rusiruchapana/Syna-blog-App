package com.rusiruchapana.Syna.blog.app.util;

import com.rusiruchapana.Syna.blog.app.dto.request.PostRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.PostResponseDTO;
import com.rusiruchapana.Syna.blog.app.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post dtoToEntity(PostRequestDTO postRequestDTO);
    PostResponseDTO entityToDto(Post post);
}
