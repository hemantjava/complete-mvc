package com.hemant.complete.mvc.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionResponse {
    private String message;
    private LocalDateTime localDateTime;
}
