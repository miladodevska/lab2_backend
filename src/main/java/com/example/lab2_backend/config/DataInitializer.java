package com.example.lab2_backend.config;


import com.example.lab2_backend.model.Author;
import com.example.lab2_backend.model.Book;
import com.example.lab2_backend.model.Country;
import com.example.lab2_backend.model.Enumerations.Category;
import com.example.lab2_backend.repository.AuthorRepository;
import com.example.lab2_backend.repository.BookRepository;
import com.example.lab2_backend.repository.CountryRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataInitializer {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public static List<Country> countries = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @PostConstruct
    public void init(){
        Country country1 = new Country("Macedonia", "Europe");
        Country country2 = new Country("China", "Asia");
        Country country3 = new Country("Serbia", "Europe");
        Country country4 = new Country("Germany", "Europe");
        Country country5 = new Country("Ecuador", "South America");

        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        this.countryRepository.save(country3);
        this.countryRepository.save(country4);
        this.countryRepository.save(country5);

        Author author1 = new Author("Slavko", "Janevski", country1);
        Author author2 = new Author("Jackie", "Chan", country2);
        Author author3 = new Author("Ivo", "Andric", country3);
        Author author4 = new Author("Carl", "Marx", country4);
        Author author5 = new Author("Fernando", "Sanchez", country5);

        this.authorRepository.save(author1);
        this.authorRepository.save(author2);
        this.authorRepository.save(author3);
        this.authorRepository.save(author4);
        this.authorRepository.save(author5);

        Book book1 = new Book("Mostot na Drina", Category.NOVEL, author3, 250);
        Book book2 = new Book("Introduction to Marxism", Category.THRILLER, author4, 120);
        Book book3 = new Book("Ulica", Category.NOVEL, author1, 50);
        Book book4 = new Book("Biography", Category.BIOGRAPHY, author2, 98);
        Book book5 = new Book("The Castle", Category.NOVEL, author3, 30);
        Book book6 = new Book("Some Book", Category.HISTORY, author5, 40);

        this.bookRepository.save(book1);
        this.bookRepository.save(book2);
        this.bookRepository.save(book3);
        this.bookRepository.save(book4);
        this.bookRepository.save(book5);
        this.bookRepository.save(book6);

    }
}