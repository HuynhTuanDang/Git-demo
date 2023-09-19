package com.example.jsfwla101.service;
import com.example.jsfwla101.entity.Category;
import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    void save(Category category);

    void update(Category category);

    Category getById(Long id);

    void deleteById(Long id);
}
