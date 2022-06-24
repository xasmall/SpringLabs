package com.xasmall.lab16.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotExistException extends RuntimeException{
    private static final long serialVersionUID = -1574716826948451793L;

    private String id;

    public UserNotExistException(String id){
        super("user not exist");
        this.id = id;
    }
}
