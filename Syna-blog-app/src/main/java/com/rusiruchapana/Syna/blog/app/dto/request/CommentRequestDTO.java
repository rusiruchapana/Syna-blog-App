package com.rusiruchapana.Syna.blog.app.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDTO {

    @NotEmpty(message = "Name should not be null or empty.")
    private String name;

    @Email(message = "Email is not valid.")
    @NotEmpty
    private String email;

    @NotEmpty(message = "Body should have minimum 10 characters.")
    private String body;
}
