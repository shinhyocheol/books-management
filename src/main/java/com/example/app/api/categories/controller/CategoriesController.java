package com.example.app.api.categories.controller;

import com.example.app.api.categories.dto.CategoryRegDto;
import com.example.app.api.categories.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"/categories"})
public class CategoriesController {

    private final CategoriesService categoriesService;

    @PostMapping(value = "")
    public void registCategory(CategoryRegDto category) throws Exception {



    }


}
