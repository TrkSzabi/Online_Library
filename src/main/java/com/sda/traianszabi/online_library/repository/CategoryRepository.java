package com.sda.traianszabi.online_library.repository;

import com.sda.traianszabi.online_library.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
