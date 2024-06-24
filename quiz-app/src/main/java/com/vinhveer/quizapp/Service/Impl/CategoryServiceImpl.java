package com.vinhveer.quizapp.Service.Impl;

import com.vinhveer.quizapp.Entity.Category;
import com.vinhveer.quizapp.Exception.InvalidRequestException;
import com.vinhveer.quizapp.Exception.ResourceNotFoundException;
import com.vinhveer.quizapp.Payload.Request.CategoryRequest;
import com.vinhveer.quizapp.Payload.Response.BodyResponse;
import com.vinhveer.quizapp.Payload.Response.CategoryResponse;
import com.vinhveer.quizapp.Repository.CategoryRepository;
import com.vinhveer.quizapp.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public BodyResponse<CategoryResponse> createCategory(CategoryRequest categoryRequest) {
        if (categoryRequest.getName() == null || categoryRequest.getName().isEmpty()) {
            throw new InvalidRequestException("Category name cannot be null or empty");
        }

        Category category = new Category();
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());

        Category savedCategory = categoryRepository.save(category);
        CategoryResponse categoryResponse = new CategoryResponse(savedCategory.getId(), savedCategory.getName(), savedCategory.getDescription());

        return new BodyResponse<>("success", "Category created successfully", categoryResponse);
    }

    @Override
    public BodyResponse<CategoryResponse> getCategoryById(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            CategoryResponse categoryResponse = new CategoryResponse(category.get().getId(), category.get().getName(), category.get().getDescription());
            return new BodyResponse<>("success", "Category retrieved successfully", categoryResponse);
        } else {
            throw new ResourceNotFoundException("Category not found with id: " + id);
        }
    }

    @Override
    public BodyResponse<List<CategoryResponse>> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = categories.stream()
                .map(category -> new CategoryResponse(category.getId(), category.getName(), category.getDescription()))
                .collect(Collectors.toList());

        return new BodyResponse<>("success", "Categories retrieved successfully", categoryResponses);
    }

    @Override
    public BodyResponse<CategoryResponse> updateCategory(String id, CategoryRequest categoryRequest) {
        if (categoryRequest.getName() == null || categoryRequest.getName().isEmpty()) {
            throw new InvalidRequestException("Category name cannot be null or empty");
        }

        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            Category category = existingCategory.get();
            category.setName(categoryRequest.getName());
            category.setDescription(categoryRequest.getDescription());
            Category updatedCategory = categoryRepository.save(category);
            CategoryResponse categoryResponse = new CategoryResponse(updatedCategory.getId(), updatedCategory.getName(), updatedCategory.getDescription());

            return new BodyResponse<>("success", "Category updated successfully", categoryResponse);
        } else {
            throw new ResourceNotFoundException("Category not found with id: " + id);
        }
    }

    @Override
    public BodyResponse<String> deleteCategory(String id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return new BodyResponse<>("success", "Category deleted successfully", id);
        } else {
            throw new ResourceNotFoundException("Category not found with id: " + id);
        }
    }
}
