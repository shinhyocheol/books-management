package com.example.app.api.books.service;

import com.example.app.api.books.domain.entity.Books;
import com.example.app.api.books.domain.entity.Categories;
import com.example.app.api.books.domain.repository.BooksRepository;
import com.example.app.api.books.domain.repository.CategoriesRepository;
import com.example.app.api.books.domain.repository.specification.BooksSpec;
import com.example.app.api.books.dto.BookRegist;
import com.example.app.api.books.dto.BookResult;
import com.example.app.api.books.dto.BookSearchKeyword;
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

    public List<BookResult> getBooks(BookSearchKeyword searchKeyword) {

        List<Books> books = booksRepository.findAll(BooksSpec.getPredicateWithKeyword(searchKeyword));

        return books.stream()
                .map(entity -> modelMapper.map(entity, BookResult.class))
                .collect(Collectors.toList());
    }

    public BookResult getBookDetail(Long bookId) {

        Books book = booksRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID를 가진 도서가 존재하지 않습니다."));

        return modelMapper.map(book, BookResult.class);

    }

    public BookResult registBook(BookRegist registBook) {

        Categories category = categoriesRepository.findById(registBook.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("해당 ID를 가진 카테고리가 존재하지 않습니다."));

        Books build = Books.builder()
                .name(registBook.getName())
                .author(registBook.getAuthor())
                .category(category)
                .build();

        Books book = booksRepository.save(build);

        return modelMapper.map(book, BookResult.class);
    }

    @Transactional
    public BookResult modifyCategoryOfBook(Long bookId, Long categoryId) {

        Books book = booksRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID를 가진 도서가 존재하지 않습니다."));

        Categories category = categoriesRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID를 가진 카테고리가 존재하지 않습니다."));

        book.modifyCategoryOfBook(category);

        return modelMapper.map(book, BookResult.class);
    }

    @Transactional
    public BookResult modifyDisabledStatusOfBook(Long bookId, String disabled) {

        Books book = booksRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID를 가진 도서가 존재하지 않습니다."));

        book.modifyDisabledOfBook(disabled);

        return modelMapper.map(book, BookResult.class);
    }

}
