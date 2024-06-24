package com.vinhveer.quizapp.Controller;

import com.vinhveer.quizapp.Payload.Request.CategoryRequest;
import com.vinhveer.quizapp.Payload.Response.BodyResponse;
import com.vinhveer.quizapp.Payload.Response.CategoryResponse;
import com.vinhveer.quizapp.Service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<BodyResponse<CategoryResponse>> createCategory(@RequestBody CategoryRequest categoryRequest) {
        BodyResponse<CategoryResponse> response = categoryService.createCategory(categoryRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodyResponse<CategoryResponse>> getCategoryById(@PathVariable String id) {
        BodyResponse<CategoryResponse> response = categoryService.getCategoryById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<BodyResponse<List<CategoryResponse>>> getAllCategories() {
        BodyResponse<List<CategoryResponse>> response = categoryService.getAllCategories();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodyResponse<CategoryResponse>> updateCategory(@PathVariable String id, @RequestBody CategoryRequest categoryRequest) {
        BodyResponse<CategoryResponse> response = categoryService.updateCategory(id, categoryRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BodyResponse<String>> deleteCategory(@PathVariable String id) {
        BodyResponse<String> response = categoryService.deleteCategory(id);
        return ResponseEntity.ok(response);
    }
}
