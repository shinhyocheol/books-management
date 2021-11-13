package com.example.app.api.books.service;

import com.example.app.api.books.domain.entity.Books;
import com.example.app.api.categories.domain.entity.Categories;
import com.example.app.api.books.domain.repository.BooksRepository;
import com.example.app.api.categories.domain.repository.CategoriesRepository;
import com.example.app.api.books.dto.BookRegDto;
import com.example.app.api.books.dto.BookResDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository booksRepository;

    private final CategoriesRepository categoriesRepository;

    private final ModelMapper modelMapper;

    public List<BookResDto> getBooks() {

        List<Books> books = booksRepository.findAll();

        return books.stream()
                .map(entity -> modelMapper.map(entity, BookResDto.class))
                .collect(Collectors.toList());
    }

    public BookResDto getBookDetail(Long bookId) {

        Books book = booksRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID를 가진 도서가 존재하지 않습니다."));

        return modelMapper.map(book, BookResDto.class);

    }

    public void registBook(BookRegDto regBook) {

        Categories category = categoriesRepository.findById(regBook.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("해당 ID를 가진 카테고리가 존재하지 않습니다."));

        Books book = Books.builder()
                .name(regBook.getName())
                .author(regBook.getAuthor())
                .category(category)
                .build();

        booksRepository.save(book);

    }

    @Transactional
    public void modifyCategoryOfBook(Long bookId, Long categoryId) {
        Books book = booksRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID를 가진 도서가 존재하지 않습니다."));

        Categories category = categoriesRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID를 가진 카테고리가 존재하지 않습니다."));

        book.modifyCategoryOfBook(category);

    }

    @Transactional
    public void modifyDisabledStatusOfBook(Long bookId, String disabled) {

        Books book = booksRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID를 가진 도서가 존재하지 않습니다."));

        book.modifyDisabledOfBook(disabled);
    }

}
