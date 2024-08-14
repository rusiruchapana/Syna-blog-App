package com.rusiruchapana.Syna.blog.app.service;

import com.rusiruchapana.Syna.blog.app.dto.request.PostRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.PaginatedPostResponseDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.PostResponseDTO;


public interface PostService {
    PostResponseDTO createPost(PostRequestDTO postRequestDTO);


    PaginatedPostResponseDTO getAllPosts(int pageNo , int pageSize, String sortBy);

    PostResponseDTO getPostById(Long postId);

    PostResponseDTO updatePostById(PostRequestDTO postRequestDTO, Long postId);

    String deletePostById(Long postId);
}
