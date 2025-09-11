package com.khan.LogInPostGre2508App.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO for User entity
 * Decoupled from JPA entities to avoid merge/transaction issues
 * Contains only categoryId instead of full Category object
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Integer id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be <= 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email must be <= 100 characters")
    private String email;

    @JsonIgnore
    private String hashedPassword; // stored password, optional

    private String rawPassword;    // input only, not persisted

    @NotNull(message = "Category is required")
    private Integer categoryId;    // Only ID, no nested Category entity

    private String domain;

    @Min(value = 0, message = "Age must be >= 0")
    private Integer age;

    @Min(value = 0, message = "Experience must be >= 0")
    private Integer experience;

    @DecimalMin(value = "0.0", inclusive = true, message = "Salary must be >= 0")
    private BigDecimal salary;

    private String imagePath;
    private String imageName;

    // ------------------ ToString ------------------
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserDTO [id=").append(id)
               .append(", name=").append(name)
               .append(", categoryId=").append(categoryId)
               .append(", email=").append(email)
               .append(", domain=").append(domain)
               .append(", age=").append(age)
               .append(", experience=").append(experience)
               .append(", salary=").append(salary)
               .append(", imagePath=").append(imagePath)
               .append(", imageName=").append(imageName)
               .append("]");
        return builder.toString();
    }
}
