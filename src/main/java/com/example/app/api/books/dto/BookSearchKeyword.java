package com.example.app.api.books.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookSearchKeyword {

    @ApiParam(value = "검색할 도서 제목", required = false, example = "너에게")
    private String bookName;

    @ApiParam(value = "검색할 도서 지은이", required = false, example = "태영")
    private String bookAuthor;

    @ApiParam(value = "검색할 도서 카테고리", required = false, example = "1")
    private Long categoryId;

}
