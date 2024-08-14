package com.rusiruchapana.Syna.blog.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedPostResponseDTO {

    private List<PostResponseDTO> content;
    private Long pageNo;
    private Long pageSize;
    private Long totalElements;
    private Long totalPages;
    private Long last;
}
