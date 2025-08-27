package com.khan.LogInPostGre2508App.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoryDAO {

    @Id
    @SequenceGenerator(
        name = "category_seq",
        sequenceName = "public.category_seq", 
        allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
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
