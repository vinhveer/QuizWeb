package com.vinhveer.quizapp.Repository;

import com.vinhveer.quizapp.Entity.Category;
import com.vinhveer.quizapp.Payload.Response.CategoryResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    List<CategoryResponse> findCategoryByName(String name);
}
