package com.example.app.api.books.domain.repository;

import com.example.app.api.books.domain.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
