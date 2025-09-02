/**
 * 
 */
package com.khan.LogInPostGre2508App.bll;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.khan.LogInPostGre2508App.dal.UserGateway;
import com.khan.LogInPostGre2508App.models.UserDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserManager {

    @Autowired
    private UserGateway aUserGateway;

    // CREATE single user
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDAO user) {
        try {
            UserDAO saved = aUserGateway.saveUser(user);
            return ResponseEntity.ok(saved);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error: " + ex.getMessage());
        }
    }

    // CREATE multiple users
    @PostMapping("/bulk")
    public ResponseEntity<?> addUsers(@RequestBody List<UserDAO> userList) {
        try {
            List<UserDAO> saved = aUserGateway.saveUsers(userList);
            return ResponseEntity.ok(saved);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error: " + ex.getMessage());
        }
    }

    // READ all users
    @GetMapping
    public ResponseEntity<List<UserDAO>> findAllUsers() {
        return ResponseEntity.ok(aUserGateway.getAllUsers());
    }

    // READ user by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable int id) {
        UserDAO user = aUserGateway.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("User with ID " + id + " not found");
        }
    }

    // READ user by name
    @GetMapping("/name/{name}")
    public ResponseEntity<?> findUserByName(@PathVariable String name) {
        UserDAO user = aUserGateway.getUserByName(name);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("User with name '" + name + "' not found");
        }
    }

    // READ user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<?> findUserByEmail(@PathVariable String email) {
        UserDAO user = aUserGateway.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("User with email '" + email + "' not found");
        }
    }

    // READ users by category ID
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<UserDAO>> findUsersByCategoryId(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(aUserGateway.getUsersByCategoryId(categoryId));
    }

    // UPDATE user
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UserDAO user) {
        try {
            user.setId(id);
            UserDAO updated = aUserGateway.updateUser(user);
            return ResponseEntity.ok(updated);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error: " + ex.getMessage());
        }
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        try {
            aUserGateway.deleteUser(id);
            return ResponseEntity.ok(Map.of("message", "User with ID " + id + " deleted successfully"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", ex.getMessage()));
        }
    }
}
