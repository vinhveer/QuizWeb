package com.vinhveer.quizappbe.Controller;

import com.vinhveer.quizappbe.Entity.Category;
import com.vinhveer.quizappbe.Payload.BodyResponse;
import com.vinhveer.quizappbe.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<BodyResponse<List<Category>>> getAllCategories() {
        BodyResponse<List<Category>> response = categoryService.getAllCategories();
        return ResponseEntity.status(response.isStatus() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodyResponse<Category>> getCategoryById(@PathVariable String id) {
        BodyResponse<Category> response = categoryService.getCategoryById(id);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping
    public ResponseEntity<BodyResponse<Category>> createCategory(@RequestBody Category category) {
        BodyResponse<Category> response = categoryService.createCategory(category);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodyResponse<Category>> updateCategory(@PathVariable String id, @RequestBody Category category) {
        BodyResponse<Category> response = categoryService.updateCategory(id, category);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BodyResponse<Void>> deleteCategory(@PathVariable String id) {
        BodyResponse<Void> response = categoryService.deleteCategory(id);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND).body(response);
    }
}
