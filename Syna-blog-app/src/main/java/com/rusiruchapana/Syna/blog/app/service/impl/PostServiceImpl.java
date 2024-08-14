package com.rusiruchapana.Syna.blog.app.service.impl;

import com.rusiruchapana.Syna.blog.app.dto.request.PostRequestDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.PaginatedPostResponseDTO;
import com.rusiruchapana.Syna.blog.app.dto.response.PostResponseDTO;
import com.rusiruchapana.Syna.blog.app.entity.Post;
import com.rusiruchapana.Syna.blog.app.exception.ResourceNotFoundException;
import com.rusiruchapana.Syna.blog.app.repository.PostRepository;
import com.rusiruchapana.Syna.blog.app.service.PostService;
import com.rusiruchapana.Syna.blog.app.util.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public PaginatedPostResponseDTO getAllPosts(int pageNo , int pageSize, String sortBy) {

        Page<Post> posts = postRepository.findAll(PageRequest.of(pageNo , pageSize, Sort.by(sortBy)));

        List<Post> posts1 = posts.getContent();
        List<PostResponseDTO> postResponseDTOS = postMapper.entityToDto(posts1);

        PaginatedPostResponseDTO paginatedPostResponseDTO = new PaginatedPostResponseDTO(
                postResponseDTOS,
                pageNo,
                pageSize,
                (int) posts.getTotalElements(),
                posts.getTotalPages(),
                posts.isLast()

        );


        return paginatedPostResponseDTO;
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
        if(post.isPresent()){
            Post post1 = new Post(
                    postId,
                    postRequestDTO.getTitle(),
                    postRequestDTO.getContent(),
                    postRequestDTO.getDescription()
            );
            postRepository.save(post1);
            PostResponseDTO postResponseDTO = postMapper.entityToDto(post1);
            return postResponseDTO;

        }else {
            throw new ResourceNotFoundException("Post", "id", Long.toString(postId));
        }

    }

    @Override
    public String deletePostById(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            postRepository.deleteById(postId);
            return "Post deleted sucess.";
        }else{
            throw new ResourceNotFoundException("Post", "id", Long.toString(postId));
        }

    }


}
