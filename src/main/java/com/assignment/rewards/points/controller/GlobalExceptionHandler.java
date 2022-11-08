package com.assignment.rewards.points.controller;

import com.assignment.rewards.points.utils.RewardPointsUtils;
import com.assignment.rewards.points.exceptions.ErrorResponse;
import com.assignment.rewards.points.exceptions.InternalErrorException;
import com.assignment.rewards.points.exceptions.InvalidRequestException;
import com.assignment.rewards.points.exceptions.NoRecordFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(NoRecordFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNoRecordFoundException(NoRecordFoundException ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(RewardPointsUtils.NO_RECORD_FOUND);
        return errorResponse;
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleInvalidRequestException(InvalidRequestException ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(InternalErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleInternalErrorException(InternalErrorException ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        return errorResponse;
    }

}
