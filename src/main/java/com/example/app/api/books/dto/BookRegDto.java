package com.example.app.api.books.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class BookRegDto {

    @NotBlank(message = "책 제목은 필수 데이터입니다.")
    private String name;

    @NotBlank(message = "책 지은이는 필수 데이터입니다.")
    private String author;

    @Min(value = 1, message = "카테고리 번호는 1보다 작을 수 없습니다.")
    private Long categoryId;

}
