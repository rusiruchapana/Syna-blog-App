package com.rusiruchapana.security.test.service;

import com.rusiruchapana.security.test.dto.request.PostRequestDTO;
import com.rusiruchapana.security.test.dto.response.PostResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    PostResponseDTO createPost(PostRequestDTO postRequestDTO);
}
