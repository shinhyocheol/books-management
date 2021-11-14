package com.example.app.exception;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * @400(BAD_REQUEST) 예외처리 핸들러
     */
    @ExceptionHandler({
            HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class,
            MissingServletRequestParameterException.class,
            UnsatisfiedServletRequestParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> badRequestException(Exception e) throws Exception {

        ErrorResponse response = ErrorResponse.of(ErrorCode.BAD_REQUEST);
        response.setDetail(e.getMessage());

        e.printStackTrace();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * @404(NOT_FOUND) 예외처리 핸들러
     */
    @ExceptionHandler({
            NotFoundException.class,
            EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> notFoundException(Exception e) throws Exception {
        ErrorResponse response = ErrorResponse.of(ErrorCode.NOT_FOUND);
        response.setDetail(e.getMessage());

        e.printStackTrace();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * @500(INTERNAL_SERVER_ERROR) 예외처리 핸들러
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> serverErrorException(Exception e) throws Exception {
        ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        response.setDetail(e.getMessage());

        e.printStackTrace();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
