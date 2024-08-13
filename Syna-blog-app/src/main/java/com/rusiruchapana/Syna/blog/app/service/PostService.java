package com.rusiruchapana.Syna.blog.app.service;

import com.rusiruchapana.Syna.blog.app.dto.request.PostRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.PostResponseDTO;


public interface PostService {
    PostResponseDTO createPost(PostRequestDTO postRequestDTO);
}
