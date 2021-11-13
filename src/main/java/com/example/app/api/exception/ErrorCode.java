package com.example.app.api.exception;

import com.example.app.util.model.EnumModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode implements EnumModel{

    BAD_REQUEST_CODE(400,  "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private int status;
    private String message;
    private String detail;

    ErrorCode (int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public int getKey() {
        return this.status;
    }

    @Override
    public String getValue() {
        return this.message;
    }
}
