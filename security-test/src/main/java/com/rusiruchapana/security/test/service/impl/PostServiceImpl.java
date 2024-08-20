package com.rusiruchapana.security.test.service.impl;

import com.rusiruchapana.security.test.dto.request.PostRequestDTO;
import com.rusiruchapana.security.test.dto.response.PostResponseDTO;
import com.rusiruchapana.security.test.entity.Post;
import com.rusiruchapana.security.test.map.PostMapper;
import com.rusiruchapana.security.test.repository.PostRepository;
import com.rusiruchapana.security.test.service.PostService;
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
        Post post = postRepository.save(postMapper.dtoToEntity(postRequestDTO));
        return postMapper.entityToDTO(post);
    }

    @Override
    public List<PostResponseDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return postMapper.dtoToEntity(posts);
    }
}
