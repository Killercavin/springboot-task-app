package com.example.springboottaskapp.exception

import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.*

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleInvalidBody(e: HttpMessageNotReadableException): Map<String, Any?> {
        return mapOf(
            "errorCode" to "INVALID_BODY",
            "message" to "Request body is missing or malformed"
        )
    }
}
