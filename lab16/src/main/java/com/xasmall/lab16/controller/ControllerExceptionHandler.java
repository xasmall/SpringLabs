package com.xasmall.lab16.controller;

import com.xasmall.lab16.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> hashleUserNotExistsException(UserNotExistException e){
        Map<String,Object> map = new HashMap<>();
        map.put("id",e.getId());
        map.put("message",e.getMessage());
        return map;
    }
}
