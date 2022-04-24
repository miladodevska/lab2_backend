package com.example.lab2_backend.web;

import com.example.lab2_backend.model.Book;
import com.example.lab2_backend.model.Dto.BookDto;
import com.example.lab2_backend.model.Exceptions.BookNotFoundException;
import com.example.lab2_backend.service.AuthorService;
import com.example.lab2_backend.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://.herokuapp.com/") //TODO
@RequestMapping("/api")
public class BookRestController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookRestController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public List<Book> findAll(){
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return this.bookService.findById(id).map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook (@RequestBody BookDto bookDto){
        return this.bookService.addBook(bookDto.getName(), bookDto.getCategory(), bookDto.getAuthor(), bookDto.getAvailableCopies())
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id){
        this.bookService.deleteBook(id);
        if (this.bookService.findById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/mark/{id}")
    public ResponseEntity<Book> markAsTaken(@PathVariable Long id){
       Book book = this.bookService.findById(id).orElseThrow(BookNotFoundException::new);
        return this.bookService.markAsTaken(book.getName()).map(book1 -> ResponseEntity.ok().body(book1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        return this.bookService.editBook(id, bookDto.getName(),bookDto.getCategory(),
                        bookDto.getAuthor(), bookDto.getAvailableCopies())
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

}
