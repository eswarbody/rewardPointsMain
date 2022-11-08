package com.assignment.rewards.points.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnProcessableErrorException extends RuntimeException {
    public UnProcessableErrorException(String s) {
        super(s);
    }
}
