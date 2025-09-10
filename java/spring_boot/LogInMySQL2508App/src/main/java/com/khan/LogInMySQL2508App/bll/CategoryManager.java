package com.khan.LogInMySQL2508App.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.khan.LogInMySQL2508App.dal.CategoryGateway;
import com.khan.LogInMySQL2508App.dto.CategoryDTO;

/**
 * CategoryManager: REST API for Category operations using DTOs
 * Returns standardized ApiResponse with data + message
 * Refactored for consistency and user-friendly messages.
 * 
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */
@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryManager {

    @Autowired
    private CategoryGateway categoryGateway;

    // ------------------ Response Wrapper ------------------
    public static class ApiResponse<T> {
        private T data;
        private String message;

        public ApiResponse(T data, String message) {
            this.data = data;
            this.message = message;
        }

        public T getData() { return data; }
        public void setData(T data) { this.data = data; }

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }

    // ------------------ CREATE ------------------

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryDTO>> addCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO saved = categoryGateway.saveCategory(categoryDTO);
        return ResponseEntity.ok(
                new ApiResponse<>(saved, "'" + saved + "' has been SAVED successfully")
        );
    }

    @PostMapping("/bulk")
    public ResponseEntity<ApiResponse<List<CategoryDTO>>> addCategories(@RequestBody List<CategoryDTO> categoryDTOList) {
        List<CategoryDTO> saved = categoryGateway.saveCategories(categoryDTOList);
        return ResponseEntity.ok(
                new ApiResponse<>(saved, saved.size() + " categories have been SAVED successfully")
        );
    }

    // ------------------ READ ------------------

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryDTO>>> findAllCategories() {
        List<CategoryDTO> categories = categoryGateway.getAllCategories();
        return ResponseEntity.ok(
                new ApiResponse<>(categories, categories.size() + " categories fetched successfully")
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryDTO>> findCategoryById(@PathVariable int id) {
        CategoryDTO category = categoryGateway.getCategoryById(id);
        String message = (category != null) ? "Category fetched successfully" : "Category with ID " + id + " not found";
        return ResponseEntity.status(category != null ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(category, message));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ApiResponse<CategoryDTO>> findCategoryByName(@PathVariable String name) {
        CategoryDTO category = categoryGateway.getCategoryByName(name);
        String message = (category != null) ? "Category fetched successfully" : "Category with name '" + name + "' not found";
        return ResponseEntity.status(category != null ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(category, message));
    }

    // ------------------ UPDATE ------------------

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryDTO>> updateCategory(@PathVariable int id, @RequestBody CategoryDTO categoryDTO) {
        categoryDTO.setId(id);
        CategoryDTO updated = categoryGateway.updateCategory(categoryDTO);
        return ResponseEntity.ok(
                new ApiResponse<>(updated, "'" + updated + "' has been UPDATED successfully")
        );
    }

    // ------------------ DELETE ------------------

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryDTO>> deleteCategory(@PathVariable int id) {
        CategoryDTO deleted = categoryGateway.deleteCategory(id);
        return ResponseEntity.ok(
                new ApiResponse<>(deleted, "'" + deleted + "' has been DELETED successfully")
        );
    }
}
