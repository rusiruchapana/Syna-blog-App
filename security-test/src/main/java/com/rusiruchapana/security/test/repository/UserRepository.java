package com.rusiruchapana.security.test.repository;

import com.rusiruchapana.security.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {

}
