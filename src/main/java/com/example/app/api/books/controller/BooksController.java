package com.example.app.api.books.controller;

import com.example.app.api.books.dto.BookRegist;
import com.example.app.api.books.dto.BookResult;
import com.example.app.api.books.dto.BookSearchKeyword;
import com.example.app.api.books.service.BooksService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
     * @ApiOperation 설명 : 도서 목록 조회요청
     * @param :
     *  bookName : 책 제목 like 조회
     *  bookAuthor : 책 저자 like 조회
     *  categoryId : 책 카테고리 where 조회
     * @ApiResponses 200, 500
     */
    @ApiOperation(value = "도서 목록 조회", notes = "도서 목록을 요청한다. 검색 조건으로 제목, 지은이, 카테고리를 사용한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR")
    })
    @ApiParam(name = "")
    @GetMapping(value = "")
    public ResponseEntity<List<BookResult>> getBooks(
            BookSearchKeyword searchKeyword) throws Exception {

        return ResponseEntity
                .ok()
                .body(booksService.getBooks(searchKeyword));
    }

    /**
     * @method 설명 : 도서 상세정보 조회요청
     * @param bookId
     * @throws Exception
     */
    @ApiOperation(value = "도서 상세 조회", notes = "아이디에 해당되는 도서의 정보를 요청한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    @GetMapping(value = "/{bookId}")
    public ResponseEntity<BookResult> getBookDetail(
            @PathVariable @ApiParam(value = "도서 ID", required = true) Long bookId) throws Exception {

        return ResponseEntity
                .ok()
                .body(booksService.getBookDetail(bookId));
    }

    /**
     * @method 설명 : 신규 도서 등록
     * @param registBook
     * @throws Exception
     */
    @ApiOperation(value = "신규 도서 등록", notes = "신규 도서 데이터를 저장한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
            @ApiResponse(code = 400, message = "BAD_REQUEST"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    @PostMapping(value = "")
    public ResponseEntity<BookResult> registBook(
            @Valid
            @RequestBody
            @ApiParam(value = "신규 도서의 정보(제목, 지은이, 소속 카테고리)", required = true)
            BookRegist registBook) throws Exception {

        return ResponseEntity
                .ok()
                .body(booksService.registBook(registBook));
    }

    /**
     * @method 설명: 도서 카테고리 변경요청
     * @param bookId
     * @param categoryId
     * @throws Exception
     */
    @ApiOperation(value = "도서 카테고리 변경", notes = "도서의 카테고리 ID를 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
            @ApiResponse(code = 400, message = "BAD_REQUEST"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    @PutMapping(value = "{bookId}/category")
    public ResponseEntity<BookResult> modifyCategoryOfBook(
            @PathVariable @ApiParam(value = "도서 ID", required = true) Long bookId,
            @RequestParam(name = "categoryId") @ApiParam(value = "변경하고자 하는 카테고리 ID", required = true) Long categoryId) throws Exception {

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
    @ApiOperation(value = "도서 상태 변경", notes = "도서 상태(훼손, 분실)값을 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
            @ApiResponse(code = 400, message = "BAD_REQUEST"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    @PutMapping(value = "{bookId}/disabled")
    public ResponseEntity<BookResult> modifyDisableStatusOfBook(
            @PathVariable @ApiParam(value = "도서 ID", required = true) Long bookId,
            @RequestParam(name = "disabled") @ApiParam(value = "변경하고자 하는 도서 상태 값", required = true) String disabled) throws Exception {

        return ResponseEntity
                .ok()
                .body(booksService.modifyDisabledStatusOfBook(bookId, disabled));
    }


}
