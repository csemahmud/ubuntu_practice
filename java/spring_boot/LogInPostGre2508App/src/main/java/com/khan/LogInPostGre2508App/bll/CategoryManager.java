/**
 * 
 */
package com.khan.LogInPostGre2508App.bll;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.khan.LogInPostGre2508App.dal.CategoryGateway;
import com.khan.LogInPostGre2508App.models.CategoryDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryManager {

    @Autowired
    private CategoryGateway aCategoryGateway;

    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody CategoryDAO category) {
        try {
            CategoryDAO saved = aCategoryGateway.saveCategory(category);
            return ResponseEntity.ok(saved);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error: " + ex.getMessage());
        }
    }

    @PostMapping("/bulk")
    public ResponseEntity<?> addCategories(@RequestBody List<CategoryDAO> categoryList) {
        try {
            List<CategoryDAO> saved = aCategoryGateway.saveCategories(categoryList);
            return ResponseEntity.ok(saved);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error: " + ex.getMessage());
        }
    }

    @GetMapping
    public List<CategoryDAO> findAllCategories() {
        return aCategoryGateway.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDAO findCategoryById(@PathVariable int id) {
        return aCategoryGateway.getCategoryById(id);
    }

    @GetMapping("/name/{name}")
    public CategoryDAO findCategoryByName(@PathVariable String name) {
        return aCategoryGateway.getCategoryByName(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody CategoryDAO category) {
        try {
            category.setId(id);
            CategoryDAO updated = aCategoryGateway.updateCategory(category);
            return ResponseEntity.ok(updated);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        try {
            aCategoryGateway.deleteCategory(id);
            return ResponseEntity.ok(Map.of("message", "Category with ID " + id + " deleted successfully"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", ex.getMessage()));
        }
    }
}
