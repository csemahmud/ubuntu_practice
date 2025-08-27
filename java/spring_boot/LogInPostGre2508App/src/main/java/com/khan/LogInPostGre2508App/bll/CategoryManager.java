/**
 * 
 */
package com.khan.LogInPostGre2508App.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khan.LogInPostGre2508App.dal.CategoryGateway;
import com.khan.LogInPostGre2508App.models.CategoryDAO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class CategoryManager {

    @Autowired
    private CategoryGateway aCategoryGateway;

    @PostMapping("/addCategory")
    public String addCategory(@RequestBody CategoryDAO category) {
        try {
            return aCategoryGateway.saveCategory(category)
                    + " has been SAVED successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }

    @PostMapping("/addCategories")
    public String addCategories(@RequestBody List<CategoryDAO> categoryList) {
        try {
            return aCategoryGateway.saveCategories(categoryList)
                    + " have been SAVED successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }

    @GetMapping("/categories")
    public List<CategoryDAO> findAllCategories(){
        return aCategoryGateway.getAllCategories();
    }

    @GetMapping("/category/{id}")
    public CategoryDAO findCategoryById(@PathVariable int id){
        return aCategoryGateway.getCategoryById(id);
    }

    @GetMapping("/categoryByName/{name}")
    public CategoryDAO findCategoryByName(@PathVariable String name){
        return aCategoryGateway.getCategoryByName(name);
    }

    @PutMapping("/updateCategory")
    public String updateCategory(@RequestBody CategoryDAO category) {
        try {
            return aCategoryGateway.updateCategory(category)
                    + " has been UPDATED successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }

    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id) {
        try {
            return aCategoryGateway.deleteCategory(id)
                    + " has been DELETED successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }

}
