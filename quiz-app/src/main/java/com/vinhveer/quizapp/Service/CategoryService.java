package com.vinhveer.quizapp.Service;

import com.vinhveer.quizapp.Payload.Request.CategoryRequest;
import com.vinhveer.quizapp.Payload.Response.BodyResponse;
import com.vinhveer.quizapp.Payload.Response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    BodyResponse<CategoryResponse> createCategory(CategoryRequest categoryRequest);
    BodyResponse<CategoryResponse> getCategoryById(String id);
    BodyResponse<List<CategoryResponse>> getAllCategories();
    BodyResponse<CategoryResponse> updateCategory(String id, CategoryRequest categoryRequest);
    BodyResponse<String> deleteCategory(String id);
}
