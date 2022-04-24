package com.example.lab2_backend.model.Exceptions;

public class BookIdNotFoundException extends RuntimeException{
    public BookIdNotFoundException(Long id){
        super("Book with id: "+id+" not found!");
    }
}