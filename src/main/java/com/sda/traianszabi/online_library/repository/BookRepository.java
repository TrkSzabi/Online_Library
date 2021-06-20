package com.sda.traianszabi.online_library.repository;

import com.sda.traianszabi.online_library.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

}
