package com.rusiruchapana.Syna.blog.app.service.impl;

import com.rusiruchapana.Syna.blog.app.dto.request.PostRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.PostResponseDTO;
import com.rusiruchapana.Syna.blog.app.entity.Post;
import com.rusiruchapana.Syna.blog.app.repository.PostRepository;
import com.rusiruchapana.Syna.blog.app.service.PostService;
import com.rusiruchapana.Syna.blog.app.util.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Override
    public PostResponseDTO createPost(PostRequestDTO postRequestDTO) {

        Post post = postMapper.dtoToEntity(postRequestDTO);
        postRepository.save(post);
        PostResponseDTO postResponseDTO = postMapper.entityToDto(post);
        return postResponseDTO;
    }

    @Override
    public List<PostResponseDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostResponseDTO> postResponseDTOS = postMapper.entityToDto(posts);
        return postResponseDTOS;
    }


}
