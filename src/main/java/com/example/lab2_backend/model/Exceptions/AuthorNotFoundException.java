package com.example.lab2_backend.model.Exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Long id){
        super(String.format("The author with id %d, was not found", id));
    }
}