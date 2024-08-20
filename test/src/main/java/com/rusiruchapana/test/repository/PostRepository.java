package com.rusiruchapana.test.repository;

import com.rusiruchapana.test.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post , Long> {
}
