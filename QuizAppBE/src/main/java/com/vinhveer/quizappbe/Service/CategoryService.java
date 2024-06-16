package com.vinhveer.quizappbe.Service;

import com.vinhveer.quizappbe.Entity.Category;
import com.vinhveer.quizappbe.Payload.BodyResponse;

import java.util.List;

public interface CategoryService {
    BodyResponse<List<Category>> getAllCategories();
    BodyResponse<Category> getCategoryById(String id);
    BodyResponse<Category> createCategory(Category category);
    BodyResponse<Category> updateCategory(String id, Category category);
    BodyResponse<Void> deleteCategory(String id);
}
