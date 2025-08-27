package com.khan.LogInMySQL2508App.util;

import com.khan.LogInMySQL2508App.models.CategoryDAO;
import com.khan.LogInMySQL2508App.repository.ICategoryRepository;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

public class CategoryValidator {

    private final ICategoryRepository categoryRepository;

    public CategoryValidator(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Checks if Admin category already exists (case-insensitive)
     */
    public boolean isAdminExists() {
        return categoryRepository.findByNameIgnoreCase("Admin") != null;
    }

    /**
     * Validates if a category creation is allowed
     */
    public void validateCreate(CategoryDAO category) {
        if ("Admin".equalsIgnoreCase(category.getName()) && isAdminExists()) {
            throw new IllegalArgumentException("Category 'Admin' already exists and is case-insensitive unique.");
        }
    }

    /**
     * Validates if a category can be updated
     */
    public void validateUpdate(CategoryDAO existingCategory, CategoryDAO updatedCategory) {
        if ("Admin".equalsIgnoreCase(existingCategory.getName())) {
            if (updatedCategory.getName() != null && !updatedCategory.getName().equalsIgnoreCase("Admin")) {
                throw new IllegalArgumentException("The 'Admin' category name cannot be changed. Only description can be modified.");
            }
            // Preserve the name
            updatedCategory.setName(existingCategory.getName());
        }
    }

    /**
     * Validates if a category can be deleted
     */
    public void validateDelete(CategoryDAO category) {
        if (category != null && "Admin".equalsIgnoreCase(category.getName())) {
            throw new IllegalArgumentException("The 'Admin' category can never be deleted.");
        }
    }
}
