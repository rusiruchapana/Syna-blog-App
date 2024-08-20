package com.rusiruchapana.security.test.map;

import com.rusiruchapana.security.test.dto.request.PostRequestDTO;
import com.rusiruchapana.security.test.dto.response.PostResponseDTO;
import com.rusiruchapana.security.test.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post dtoToEntity(PostRequestDTO postRequestDTO);
    PostResponseDTO entityToDTO(Post post);
}
