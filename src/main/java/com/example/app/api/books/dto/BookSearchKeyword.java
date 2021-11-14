package com.example.app.api.books.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookSearchKeyword {

    private String bookName;

    private String bookAuthor;

    private Long categoryId;

}
