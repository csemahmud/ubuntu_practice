/**
 * 
 */
/**
 * 
 */
package com.khan.LogInPostGre2508App.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khan.LogInPostGre2508App.util.CategoryValidator;
import com.khan.LogInPostGre2508App.models.CategoryDAO;
import com.khan.LogInPostGre2508App.repository.ICategoryRepository;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Service
public class CategoryGateway {

	@Autowired
    private ICategoryRepository categoryRepository;

    private CategoryValidator validator;

    @PostConstruct
    public void init() {
        validator = new CategoryValidator(categoryRepository);
        initializeAdminCategory();
    }

    private void initializeAdminCategory() {
        if (!validator.isAdminExists()) {
            CategoryDAO admin = CategoryDAO.builder()
                    .name("Admin")
                    .description("Default Admin Category")
                    .build();
            categoryRepository.save(admin);
            System.out.println("Admin category created automatically on startup.");
        }
    }

    public CategoryDAO saveCategory(CategoryDAO category) {
        validator.validateCreate(category);
        return categoryRepository.save(category);
    }

    public List<CategoryDAO> saveCategories(List<CategoryDAO> categoryList) {
        for (CategoryDAO cat : categoryList) {
            validator.validateCreate(cat);
        }
        return categoryRepository.saveAll(categoryList);
    }

    public CategoryDAO updateCategory(CategoryDAO category) {
        if (category.getId() == null) {
            throw new IllegalArgumentException("Category ID must be provided for update.");
        }
        CategoryDAO existingCategory = categoryRepository.findById(category.getId()).orElse(null);
        if (existingCategory == null) {
            throw new IllegalArgumentException("Category not found with ID: " + category.getId());
        }

        validator.validateUpdate(existingCategory, category);
        return categoryRepository.save(category);
    }

    public CategoryDAO deleteCategory(int id) throws Exception {
        CategoryDAO existingCategory = categoryRepository.findById(id).orElse(null);
        validator.validateDelete(existingCategory);

        categoryRepository.delete(existingCategory);
        return existingCategory;
    }

    // Other methods (getAllCategories, getCategoryById, getCategoryByName) remain unchanged

    public List<CategoryDAO> getAllCategories() {
        return categoryRepository.findAll();
    }

    public CategoryDAO getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public CategoryDAO getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }
}
