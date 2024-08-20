package com.rusiruchapana.Syna.blog.app.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDTO {

    @NotEmpty
    @Size(min = 2 , message = "Post title should have minimum 2 charactors.")
    private String title;

    @NotEmpty
    @Size(min = 10 , message = "Post title should have minimum 10 charactors.")
    private String description;

    @NotEmpty
    @Size(min = 10 , message = "Post title should have minimum 10 charactors.")
    private String content;
}
