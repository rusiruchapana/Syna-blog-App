package com.rusiruchapana.Syna.blog.app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    
    private String title;
    private String description;
    private String content;
}
