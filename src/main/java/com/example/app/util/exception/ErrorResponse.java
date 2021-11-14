package com.example.app.util.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {

    private String message;
    private int status;
    private String detail;

    public ErrorResponse(ErrorCode err) {
        this.message = err.getMessage();
        this.status = err.getStatus();
        this.detail = err.getDetail();
    }

    public static ErrorResponse of(ErrorCode err) {
        return new ErrorResponse(err);
    }

}
