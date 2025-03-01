package com.common.exception;

import com.common.dto.ApiResponse;

import com.common.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("서버 에러 발생", "500");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(ApiResponse.failure(errorResponse.getMessage(), errorResponse.getErrorCode()));
    }

    // 추가예정
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Void>> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "400");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(ApiResponse.failure(errorResponse.getMessage(), errorResponse.getErrorCode()));
    }
}
