package com.rusiruchapana.Syna.blog.app.repository;

import com.rusiruchapana.Syna.blog.app.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post , Long> {
}
