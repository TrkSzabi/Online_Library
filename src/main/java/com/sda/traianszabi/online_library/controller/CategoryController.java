package com.sda.traianszabi.online_library.controller;

import com.sda.traianszabi.online_library.model.Category;
import com.sda.traianszabi.online_library.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category/create")
    public String createCategory(@Valid @RequestBody Category category) {
        categoryService.save(category);
        return "Category succesfully saved";
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }
}
