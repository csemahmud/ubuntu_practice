package com.khan.LogInPostGre2508App.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO for User entity
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */
@Data
public class UserDTO {

    private Integer id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    private String hashedPassword; // stored password, optional

    private String rawPassword;    // input only

    @NotNull(message = "Category is required")
    private Integer categoryId;

    private String domain;
    private Integer age;
    private Integer experience;

    @DecimalMin(value = "0.0", inclusive = true, message = "Salary must be >= 0")
    private BigDecimal salary;

    private String imagePath;
    private String imageName;
}
