package com.example.app.api.books.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class BookRegist {

    @ApiParam(value = "책 제목", required = true, example = "너에게 해주지 못한 말들")
    @NotBlank(message = "책 제목은 필수 데이터입니다.")
    private String name;

    @ApiParam(value = "책 지은이", required = true, example = "권태영")
    @NotBlank(message = "책 지은이는 필수 데이터입니다.")
    private String author;

    @ApiParam(value = "책 소속 카테고리", required = true, example = "1")
    @Min(value = 1, message = "해당 카테고리 ID는 존재하지 않습니다.")
    private Long categoryId;

}
