package com.example.app.api.books.controller;

import com.example.app.api.books.dto.ResBookDto;
import com.example.app.api.books.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"/books"})
public class BooksController {

    private final BooksService booksService;

    @GetMapping(value = "")
    public ResponseEntity<List<ResBookDto>> getBooks() throws Exception {

        return ResponseEntity
                .ok()
                .body(booksService.getBooks());

    }
}
