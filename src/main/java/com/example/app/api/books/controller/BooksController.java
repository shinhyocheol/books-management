package com.example.app.api.books.controller;

import com.example.app.api.books.dto.BookRegist;
import com.example.app.api.books.dto.BookResult;
import com.example.app.api.books.dto.BookSearchKeyword;
import com.example.app.api.books.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"/books"})
public class BooksController {

    private final BooksService booksService;

    /**
     * @method 설명 : 도서 목록 조회요청
     * @param :
     *  bookName : 책 제목 like 조회
     *  bookAuthor : 책 저자 like 조회
     *  categoryId : 책 카테고리 where 조회
     * @throws Exception
     */
    @GetMapping(value = "")
    public ResponseEntity<List<BookResult>> getBooks(BookSearchKeyword searchKeyword) throws Exception {

        return ResponseEntity
                .ok()
                .body(booksService.getBooks(searchKeyword));
    }

    /**
     * @method 설명 : 도서 상세정보 조회요청
     * @param bookId
     * @throws Exception
     */
    @GetMapping(value = "/{bookId}")
    public ResponseEntity<BookResult> getBookDetail(
            @PathVariable Long bookId) throws Exception {

        return ResponseEntity
                .ok()
                .body(booksService.getBookDetail(bookId));
    }

    /**
     * @method 설명 : 신규 도서 등록
     * @param regBook
     * @throws Exception
     */
    @PostMapping(value = "")
    public ResponseEntity<BookResult> registBook(
            @Valid @RequestBody BookRegist regBook) throws Exception {

        return ResponseEntity
                .ok()
                .body(booksService.registBook(regBook));
    }

    /**
     * @method 설명: 도서 카테고리 변경요청
     * @param bookId
     * @param categoryId
     * @throws Exception
     */
    @PutMapping(value = "{bookId}/category")
    public ResponseEntity<BookResult> modifyCategoryOfBook(
            @PathVariable Long bookId,
            @RequestParam(name = "categoryId") Long categoryId) throws Exception {

        return ResponseEntity
                .ok()
                .body(booksService.modifyCategoryOfBook(bookId, categoryId));
    }

    /**
     * @method 설명 : 도서 상태(대여가능 여부) 변경요청
     * @param bookId
     * @param disabled
     * @throws Exception
     */
    @PutMapping(value = "{bookId}/disabled")
    public ResponseEntity<BookResult> modifyDisableStatusOfBook(
            @PathVariable Long bookId,
            @RequestParam(name = "disabled") String disabled) throws Exception {

        return ResponseEntity
                .ok()
                .body(booksService.modifyDisabledStatusOfBook(bookId, disabled));
    }


}
