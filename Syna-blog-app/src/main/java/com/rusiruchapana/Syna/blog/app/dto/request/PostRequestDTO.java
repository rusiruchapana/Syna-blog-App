package com.rusiruchapana.Syna.blog.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDTO {

    private String title;
    private String description;
    private String content;
}