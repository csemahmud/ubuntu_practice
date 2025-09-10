package com.khan.LogInMySQL2508App.util;

import com.khan.LogInMySQL2508App.dto.CategoryDTO;
import com.khan.LogInMySQL2508App.models.CategoryDAO;

/**
 * Mapper for Category entity
 * Converts between CategoryDAO and CategoryDTO
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */
public class CategoryMapper {

    // ------------------ DTO -> Entity ------------------
    public static CategoryDAO toEntity(CategoryDTO dto) {
        if (dto == null) return null;
        CategoryDAO category = new CategoryDAO();
        category.setId(dto.getId());
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }

    // ------------------ Entity -> DTO ------------------
    public static CategoryDTO toDTO(CategoryDAO category) {
        if (category == null) return null;
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }
}
