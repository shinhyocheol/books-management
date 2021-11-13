package com.example.app.api.books.controller;

import com.example.app.api.books.domain.entity.Books;
import com.example.app.api.books.dto.BookRegDto;
import com.example.app.api.books.dto.BookResDto;
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
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public ResponseEntity<List<BookResDto>> getBooks() throws Exception {

        return ResponseEntity
                .ok()
                .body(booksService.getBooks());
    }

    /**
     * @method 설명 : 도서 상세정보 조회요청
     * @param bookId
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/{bookId}")
    public ResponseEntity<BookResDto> getBookDetail(
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
    public ResponseEntity<BookResDto> registBook(
            @Valid @RequestBody BookRegDto regBook) throws Exception {

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
    public ResponseEntity<BookResDto> modifyCategoryOfBook(
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
    public ResponseEntity<BookResDto> modifyDisableStatusOfBook(
            @PathVariable Long bookId,
            @RequestParam(name = "disabled") String disabled) throws Exception {

        return ResponseEntity
                .ok()
                .body(booksService.modifyDisabledStatusOfBook(bookId, disabled));
    }


}
