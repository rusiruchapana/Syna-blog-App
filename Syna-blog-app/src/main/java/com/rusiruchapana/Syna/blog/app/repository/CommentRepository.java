package com.rusiruchapana.Syna.blog.app.repository;

import com.rusiruchapana.Syna.blog.app.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment , Long> {
}
