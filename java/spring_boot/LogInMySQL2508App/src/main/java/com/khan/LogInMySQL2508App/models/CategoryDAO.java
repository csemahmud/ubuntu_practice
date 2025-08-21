package com.khan.LogInMySQL2508App.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "tbl_category")
public class CategoryDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // safer than int

    @NotBlank
    @Size(max = 100)
    @Column(name = "category_name", length = 100, unique = true, nullable = false)
    private String name;

    @Size(max = 255)
    @Column
    private String description;

    // ------------------ Equals and HashCode ------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryDAO)) return false;
        CategoryDAO other = (CategoryDAO) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    // ------------------ ToString ------------------
    @Override
    public String toString() {
        return "CategoryDAO [id=" + id + ", name=" + name + ", description=" + description + "]";
    }
}
