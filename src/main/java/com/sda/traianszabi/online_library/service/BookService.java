package com.sda.traianszabi.online_library.service;

import com.sda.traianszabi.online_library.model.Book;
import com.sda.traianszabi.online_library.model.Category;
import com.sda.traianszabi.online_library.repository.BookRepository;
import com.sda.traianszabi.online_library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookService(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void save(Book book){
        book.setCategory(categoryRepository.findById(book.getCategory().getId()).orElse(null));
        bookRepository.save(book);

    }
    public void addBook(Book book, Category category){
        bookRepository.save(book);
        categoryRepository.save(category);
    }

    public List<Book> findAll() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(),
                false).collect(Collectors.toList());

    }



    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }


    public Optional<Book> findById(Long bookId) {
        return bookRepository.findById(bookId);
    }

}
