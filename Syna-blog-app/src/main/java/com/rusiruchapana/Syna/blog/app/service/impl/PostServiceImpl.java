package com.rusiruchapana.Syna.blog.app.service.impl;

import com.rusiruchapana.Syna.blog.app.dto.request.PostRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.PostResponseDTO;
import com.rusiruchapana.Syna.blog.app.entity.Post;
import com.rusiruchapana.Syna.blog.app.exception.ResourceNotFoundException;
import com.rusiruchapana.Syna.blog.app.repository.PostRepository;
import com.rusiruchapana.Syna.blog.app.service.PostService;
import com.rusiruchapana.Syna.blog.app.util.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public PostResponseDTO getPostById(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            return (postMapper.entityToDto(post.get()));
        }else {
            throw new ResourceNotFoundException("Post","id",Long.toString(postId));
        }
    }

    @Override
    public PostResponseDTO updatePostById(PostRequestDTO postRequestDTO, Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        Post post1 = new Post(
                postId,
                postRequestDTO.getTitle(),
                postRequestDTO.getContent(),
                postRequestDTO.getDescription()
        );
        postRepository.save(post1);
        PostResponseDTO postResponseDTO = postMapper.entityToDto(post1);
        return postResponseDTO;
    }


}
