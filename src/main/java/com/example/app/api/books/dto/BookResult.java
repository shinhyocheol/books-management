package com.example.app.api.books.dto;

import com.example.app.api.books.domain.entity.Categories;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BookResult {

    private Long id;

    private String name;

    private String author;

    private String disabled;

    private Long categoryId;

    private String categoryName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
