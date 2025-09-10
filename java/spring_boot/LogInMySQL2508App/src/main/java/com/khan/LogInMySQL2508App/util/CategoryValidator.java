package com.khan.LogInMySQL2508App.util;

import com.khan.LogInMySQL2508App.dto.CategoryDTO;
import com.khan.LogInMySQL2508App.repository.ICategoryRepository;

/**
 * CategoryValidator: Enforces business rules for CategoryDTO
 * - Ensures 'Admin' category uniqueness, immutability, and non-deletable rule
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */
public class CategoryValidator {

    private static final String ADMIN = "Admin";

    private final ICategoryRepository categoryRepository;

    public CategoryValidator(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // ------------------ Helper ------------------

    /**
     * Checks if 'Admin' category exists (case-insensitive)
     */
    public boolean isAdminExists() {
        return categoryRepository.existsByNameIgnoreCase(ADMIN);
    }

    

    // ------------------ Validation Methods ------------------

    /**
     * Validate category creation
     */
    public void validateCreate(CategoryDTO categoryDTO) {
        if (categoryDTO == null || categoryDTO.getName() == null || categoryDTO.getName().isBlank()) {
            throw new IllegalArgumentException("Category and category name cannot be null or empty.");
        }

        if (ADMIN.equalsIgnoreCase(categoryDTO.getName()) && isAdminExists()) {
            throw new IllegalArgumentException("Category 'Admin' already exists and must be unique.");
        }
    }

    /**
     * Validate category update
     */
    public void validateUpdate(CategoryDTO existingDTO, CategoryDTO updatedDTO) {
        if (existingDTO == null || updatedDTO == null) {
            throw new IllegalArgumentException("Existing and updated category cannot be null.");
        }

        if (ADMIN.equalsIgnoreCase(existingDTO.getName())) {
            if (updatedDTO.getName() != null && !ADMIN.equalsIgnoreCase(updatedDTO.getName())) {
                throw new IllegalArgumentException(
                    "The 'Admin' category name cannot be changed. Only description can be modified."
                );
            }
            // Preserve 'Admin' name
            updatedDTO.setName(ADMIN);
        }
    }

    /**
     * Validate category deletion
     */
    public void validateDelete(CategoryDTO categoryDTO) {
        if (categoryDTO == null) {
            throw new IllegalArgumentException("Category cannot be null.");
        }

        if (ADMIN.equalsIgnoreCase(categoryDTO.getName())) {
            throw new IllegalArgumentException("The 'Admin' category can never be deleted.");
        }
    }
}
