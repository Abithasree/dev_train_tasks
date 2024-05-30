package com.example.asmtest.controller;

import com.example.asmtest.entity.Category;
import com.example.asmtest.repository.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;


    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/search")
    public List<Category> searchCategories(@RequestParam String name) {
        return categoryRepository.findByNameContaining(name);
    }
}
