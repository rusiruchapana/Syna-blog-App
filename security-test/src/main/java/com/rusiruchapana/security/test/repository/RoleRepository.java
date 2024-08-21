package com.rusiruchapana.security.test.repository;

import com.rusiruchapana.security.test.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role , Long> {
}
