package com.example.lab2_backend.service;

import com.example.lab2_backend.model.Author;
import com.example.lab2_backend.model.Book;
import com.example.lab2_backend.model.Enumerations.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService  {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> addBook(String name, Category category, Long authorId, Integer availableCopies);
    void deleteBook(Long id);
    Optional<Book> editBook(Long id, String name, Category category, Long authorId, Integer availableCopies);
    Optional<Book> markAsTaken(String name);
}
