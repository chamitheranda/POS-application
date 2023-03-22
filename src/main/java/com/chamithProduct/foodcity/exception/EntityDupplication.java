package com.chamithProduct.foodcity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class EntityDupplication extends RuntimeException {
    public EntityDupplication(String message){
        super(message);
    }
}
