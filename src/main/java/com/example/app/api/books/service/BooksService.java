package com.example.app.api.books.service;

import com.example.app.api.books.domain.entity.Books;
import com.example.app.api.books.domain.repository.BooksRepository;
import com.example.app.api.books.dto.ResBookDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository booksRepository;

    private final ModelMapper modelMapper;

    public List<ResBookDto> getBooks() {

        List<Books> books = booksRepository.findAll();

        return books.stream()
                .map(entity -> modelMapper.map(entity, ResBookDto.class))
                .collect(Collectors.toList());
    }
}
