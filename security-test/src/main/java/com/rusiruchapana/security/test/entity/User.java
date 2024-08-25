package com.rusiruchapana.security.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false , unique = true)
    private String username;

    @Column(nullable = false , unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id" , referencedColumnName = "id")
    )
    Set<Role> roles;
}
