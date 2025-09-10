package com.khan.LogInMySQL2508App.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO for Category entity
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */
@Data
public class CategoryDTO {

    private Integer id;

    @NotBlank(message = "Category name is required")
    @Size(max = 100, message = "Category name must be <= 100 characters")
    private String name;

    @Size(max = 255, message = "Description must be <= 255 characters")
    private String description;

    // ------------------ ToString ------------------
    @Override
    public String toString() {
        return "CategoryDTO [id=" + id + ", name=" + name + ", description=" + description + "]";
    }
}
