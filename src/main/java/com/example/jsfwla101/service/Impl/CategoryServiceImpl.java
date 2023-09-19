package com.example.jsfwla101.service.Impl;

import com.example.jsfwla101.entity.Category;
import com.example.jsfwla101.repository.CategoryRepository;
import com.example.jsfwla101.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    @Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category getById(Long id) {
        Optional<Category> category=categoryRepository.findById(id);
        if (category.isPresent()){
            Category userGet=category.get();
            return userGet;
        }else {
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
