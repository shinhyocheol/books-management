package com.example.app.api.books.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BookResult {

    @ApiModelProperty(value = "도서 ID", example = "1")
    private Long id;

    @ApiModelProperty(value = "도서 제목", example = "너에게 해주지 못한 말들")
    private String name;

    @ApiModelProperty(value = "도서 지은이", example = "권태영")
    private String author;

    @ApiModelProperty(value = "도서 상태(분실, 훼손)", example = "N")
    private String disabled;

    @ApiModelProperty(value = "도서 카테고리 ID", example = "1")
    private Long categoryId;

    @ApiModelProperty(value = "도서 카테고리명", example = "문학")
    private String categoryName;

    @ApiModelProperty(value = "도서 데이터 등록일자")
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "도서 데이터 수정일자")
    private LocalDateTime updatedAt;

}
