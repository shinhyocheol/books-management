package com.example.app.api.books.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookSearchKeyword {

    @ApiParam(value = "검색할 책 제목", required = false)
    private String bookName;

    @ApiParam(value = "검색할 책의 지은이", required = false)
    private String bookAuthor;

    @ApiParam(value = "검색할 책의 카테고리", required = false)
    private Long categoryId;

}
