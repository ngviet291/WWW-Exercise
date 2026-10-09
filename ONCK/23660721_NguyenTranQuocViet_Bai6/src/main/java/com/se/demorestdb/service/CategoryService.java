package com.se.demorestdb.service;

import com.se.demorestdb.model.Category;
import com.se.demorestdb.repo.CategoryRepoImpl;
import jakarta.inject.Inject;

import java.util.List;

public class CategoryService {
    @Inject
    private CategoryRepoImpl categoryRepo;
    public CategoryService() {
    }
    public List<Category> getAllCategories() {
        return categoryRepo.getAllCategories();
    }
    public Category getCategoryById(int id) {
        return categoryRepo.getCategoryById(id);
    }
    public void addCategory(Category category) {
        categoryRepo.addCategory(category);
    }
    public void updateCategory(Category category) {
        categoryRepo.updateCategory(category);
    }
    public void deleteCategory(int id) {
        categoryRepo.deleteCategory(id);
    }
}
