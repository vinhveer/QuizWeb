package com.vinhveer.quizappbe.Service.Impl;

import com.vinhveer.quizappbe.Entity.Category;
import com.vinhveer.quizappbe.Payload.BodyResponse;
import com.vinhveer.quizappbe.Repository.CategoryRepository;
import com.vinhveer.quizappbe.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public BodyResponse<List<Category>> getAllCategories() {
        try {
            List<Category> categories = categoryRepository.findAll();
            return new BodyResponse<>(true, "Categories retrieved successfully", categories);
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to retrieve categories: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<Category> getCategoryById(String id) {
        try {
            Optional<Category> category = categoryRepository.findById(id);
            if (category.isPresent()) {
                return new BodyResponse<>(true, "Category retrieved successfully", category.get());
            } else {
                return new BodyResponse<>(false, "Category not found", null);
            }
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to retrieve category: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<Category> createCategory(Category category) {
        try {
            Category savedCategory = categoryRepository.save(category);
            return new BodyResponse<>(true, "Category created successfully", savedCategory);
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to create category: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<Category> updateCategory(String id, Category category) {
        try {
            Optional<Category> existingCategory = categoryRepository.findById(id);
            if (existingCategory.isPresent()) {
                Category updatedCategory = existingCategory.get();
                updatedCategory.setName(category.getName());
                updatedCategory.setDescription(category.getDescription());
                categoryRepository.save(updatedCategory);
                return new BodyResponse<>(true, "Category updated successfully", updatedCategory);
            } else {
                return new BodyResponse<>(false, "Category not found", null);
            }
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to update category: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<Void> deleteCategory(String id) {
        try {
            Optional<Category> category = categoryRepository.findById(id);
            if (category.isPresent()) {
                categoryRepository.deleteById(id);
                return new BodyResponse<>(true, "Category deleted successfully", null);
            } else {
                return new BodyResponse<>(false, "Category not found", null);
            }
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to delete category: " + e.getMessage(), null);
        }
    }
}
