package com.rusiruchapana.Syna.blog.app.service;

import com.rusiruchapana.Syna.blog.app.dto.request.PostRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.PostResponseDTO;

import java.util.List;


public interface PostService {
    PostResponseDTO createPost(PostRequestDTO postRequestDTO);


    List<PostResponseDTO> getAllPosts(int pageNo , int pageSize);

    PostResponseDTO getPostById(Long postId);

    PostResponseDTO updatePostById(PostRequestDTO postRequestDTO, Long postId);

    String deletePostById(Long postId);
}
