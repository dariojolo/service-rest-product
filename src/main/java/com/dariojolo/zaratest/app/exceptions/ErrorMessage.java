package com.dariojolo.zaratest.app.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@AllArgsConstructor
@Builder
@ToString
public class ErrorMessage {
    private String exception;
    private String message;
    private String path;
}
