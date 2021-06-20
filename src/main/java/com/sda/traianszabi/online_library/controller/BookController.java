package com.sda.traianszabi.online_library.controller;

import com.sda.traianszabi.online_library.error.ResourceNotFoundException;
import com.sda.traianszabi.online_library.model.Book;
import com.sda.traianszabi.online_library.service.BookService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId) throws ResourceNotFoundException {
        Optional<Book> book = bookService.findById(bookId);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        throw new ResourceNotFoundException("Book wit id : " + bookId + " was not found");
    }

    @PostMapping("/books/create")
    public String createBook(@Valid @RequestBody Book book){
        bookService.save(book);
        return "Book succesfully saved";
    }
}
