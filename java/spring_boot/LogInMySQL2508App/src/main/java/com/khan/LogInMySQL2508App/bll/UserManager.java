package com.khan.LogInMySQL2508App.bll;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.khan.LogInMySQL2508App.dal.UserGateway;
import com.khan.LogInMySQL2508App.dto.UserDTO;

/**
 * UserManager: REST API layer using DTOs
 * Maps incoming DTOs to entities via UserMapper and delegates to UserGateway
 * Author: KHAN MAHMUDUL HASAN CSE BD JP
 */
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserManager {

    @Autowired
    private UserGateway userGateway;

    // ------------------ CREATE ------------------
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
        try {
            UserDTO savedDTO = userGateway.saveUser(userDTO);
            return ResponseEntity.ok(savedDTO);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", ex.getMessage()));
        }
    }

    @PostMapping("/bulk")
    public ResponseEntity<?> addUsers(@RequestBody List<UserDTO> userDTOList) {
        try {
            List<UserDTO> savedDTOs = userGateway.saveUsers(userDTOList);
            return ResponseEntity.ok(savedDTOs);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", ex.getMessage()));
        }
    }

    // ------------------ READ ------------------
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return ResponseEntity.ok(userGateway.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable int id) {
        UserDTO dto = userGateway.getUserById(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(Map.of("error", "User with ID " + id + " not found"));
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findUserByName(@PathVariable String name) {
        UserDTO dto = userGateway.getUserByName(name);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(Map.of("error", "User with name '" + name + "' not found"));
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> findUserByEmail(@PathVariable String email) {
        UserDTO dto = userGateway.getUserByEmail(email);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(Map.of("error", "User with email '" + email + "' not found"));
        }
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<UserDTO>> findUsersByCategoryId(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(userGateway.getUsersByCategoryId(categoryId));
    }

    // ------------------ UPDATE ------------------
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        try {
            userDTO.setId(id);
            UserDTO updatedDTO = userGateway.updateUser(userDTO);
            return ResponseEntity.ok(updatedDTO);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", ex.getMessage()));
        }
    }

    // ------------------ DELETE ------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        try {
            UserDTO deletedDTO = userGateway.deleteUser(id);
            return ResponseEntity.ok(Map.of(
                    "message", "User with ID " + id + " deleted successfully",
                    "user", deletedDTO
            ));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", ex.getMessage()));
        }
    }
}
