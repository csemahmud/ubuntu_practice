package com.khan.LogInPostGre2508App.dal;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khan.LogInPostGre2508App.dto.CategoryDTO;
import com.khan.LogInPostGre2508App.models.CategoryDAO;
import com.khan.LogInPostGre2508App.repository.ICategoryRepository;
import com.khan.LogInPostGre2508App.util.CategoryMapper;
import com.khan.LogInPostGre2508App.util.CategoryValidator;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * CategoryGateway: Handles CRUD operations for Category using DTOs.
 * Enforces validation via CategoryValidator.
 * Fully DTO-centric for cleaner service layer.
 * 
 * @author KHAN MAHMUDUL HASAN CSE BD JP
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

    // ------------------ CREATE ------------------

    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        validator.validateCreate(categoryDTO);
        CategoryDAO saved = categoryRepository.save(CategoryMapper.toEntity(categoryDTO));
        return CategoryMapper.toDTO(saved);
    }

    public List<CategoryDTO> saveCategories(List<CategoryDTO> categoryDTOList) {
        categoryDTOList.forEach(validator::validateCreate);
        List<CategoryDAO> savedList = categoryRepository.saveAll(
                categoryDTOList.stream()
                        .map(CategoryMapper::toEntity)
                        .collect(Collectors.toList())
        );
        return savedList.stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    // ------------------ UPDATE ------------------

    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        if (categoryDTO.getId() == null) {
            throw new IllegalArgumentException("Category ID must be provided for update.");
        }

        CategoryDAO existing = categoryRepository.findById(categoryDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Category not found with ID: " + categoryDTO.getId()
                ));

        validator.validateUpdate(CategoryMapper.toDTO(existing), categoryDTO);

        CategoryDAO updated = categoryRepository.save(CategoryMapper.toEntity(categoryDTO));
        return CategoryMapper.toDTO(updated);
    }

    // ------------------ DELETE ------------------

    public CategoryDTO deleteCategory(int id) {
        CategoryDAO existing = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with ID: " + id));

        validator.validateDelete(CategoryMapper.toDTO(existing));
        categoryRepository.delete(existing);

        return CategoryMapper.toDTO(existing);
    }

    // ------------------ READ ------------------

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO getCategoryById(int id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toDTO)
                .orElse(null);
    }

    public CategoryDTO getCategoryByName(String name) {
        return categoryRepository.findByName(name)
                .map(CategoryMapper::toDTO)
                .orElse(null);
    }
}
