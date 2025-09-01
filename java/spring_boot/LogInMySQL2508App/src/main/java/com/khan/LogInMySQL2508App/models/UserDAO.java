package com.khan.LogInMySQL2508App.models;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "tbl_user")
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // nullable-safe before persistence

    @NotBlank
    @Size(max = 100)
    @Column(name = "user_name", length = 100, unique = true, nullable = false)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryDAO category;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @NotBlank
    @Size(max = 100)
    @Column(name = "password", length = 100, nullable = false)
    private String hashedPassword;

    @Transient
    private String rawPassword; // for input only, not stored

    @Size(max = 255)
    @Column(name = "image_path", length = 255)
    private String imagePath;

    @Size(max = 100)
    @Column(name = "image_name", length = 100)
    private String imageName;

    @Size(max = 255)
    @Column
    private String domain;

    @Min(0)
    @Column
    private Integer age;

    @Min(0)
    @Column
    private Integer experience;

    @DecimalMin(value = "0.0", inclusive = true)
    @Column(precision = 15, scale = 2, nullable = true)
    private BigDecimal salary;

    // ------------------ Equals and HashCode ------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDAO)) return false;
        UserDAO other = (UserDAO) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    // ------------------ ToString ------------------
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserDAO [id=").append(id)
               .append(", name=").append(name);

        if (category != null && category.getId() != null) {
            builder.append(", categoryId=").append(category.getId());
        }

        builder.append(", email=").append(email)
               .append(", imagePath=").append(imagePath)
               .append(", imageName=").append(imageName)
               .append(", domain=").append(domain)
               .append(", age=").append(age)
               .append(", experience=").append(experience)
               .append(", salary=").append(salary)
               .append("]");

        return builder.toString();
    }

    // ------------------ Helper ------------------
    /**
     * Sets raw password and hashes it.
     * Example: use BCrypt or Argon2 in service layer.
     */
    public void setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
        if (rawPassword != null && !rawPassword.isBlank()) {
            // hash using your preferred method, e.g., BCrypt
            // this.hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
        }
    }
}