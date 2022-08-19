package com.techelevator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InsufficientCheckInsException extends RuntimeException {

        public InsufficientCheckInsException(String message){
            super(message);
        }
}

