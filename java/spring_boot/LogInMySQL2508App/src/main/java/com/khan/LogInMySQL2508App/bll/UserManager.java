package com.khan.LogInMySQL2508App.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.khan.LogInMySQL2508App.dal.UserGateway;
import com.khan.LogInMySQL2508App.dto.UserDTO;

/**
 * UserManager: REST API for User operations using DTOs
 * Returns standardized ApiResponse with data + message
 * 
 * Refactored to consistently send clear messages and handle not-found cases
 * 
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserManager {

    @Autowired
    private UserGateway userGateway;

    // ------------------ Response Wrapper ------------------
    public static class ApiResponse<T> {
        private T data;
        private String message;

        public ApiResponse(T data, String message) {
            this.data = data;
            this.message = message;
        }

        public T getData() { return data; }
        public void setData(T data) { this.data = data; }

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }

    // ------------------ CREATE ------------------

    @PostMapping
    public ResponseEntity<ApiResponse<UserDTO>> addUser(@RequestBody UserDTO userDTO) {
        UserDTO savedDTO = userGateway.saveUser(userDTO);
        return ResponseEntity.ok(
                new ApiResponse<>(savedDTO, "'" + savedDTO + "' has been SAVED successfully")
        );
    }

    @PostMapping("/bulk")
    public ResponseEntity<ApiResponse<List<UserDTO>>> addUsers(@RequestBody List<UserDTO> userDTOList) {
        List<UserDTO> savedDTOs = userGateway.saveUsers(userDTOList);
        return ResponseEntity.ok(
                new ApiResponse<>(savedDTOs, savedDTOs.size() + " users have been SAVED successfully")
        );
    }

    // ------------------ READ ------------------

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDTO>>> findAllUsers() {
        List<UserDTO> users = userGateway.getAllUsers();
        return ResponseEntity.ok(
                new ApiResponse<>(users, users.size() + " users fetched successfully")
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> findUserById(@PathVariable int id) {
        UserDTO dto = userGateway.getUserById(id);
        String message = (dto != null) ? "User fetched successfully" : "User with ID " + id + " not found";
        return ResponseEntity.status(dto != null ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(dto, message));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ApiResponse<UserDTO>> findUserByName(@PathVariable String name) {
        UserDTO dto = userGateway.getUserByName(name);
        String message = (dto != null) ? "User fetched successfully" : "User with name '" + name + "' not found";
        return ResponseEntity.status(dto != null ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(dto, message));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ApiResponse<UserDTO>> findUserByEmail(@PathVariable String email) {
        UserDTO dto = userGateway.getUserByEmail(email);
        String message = (dto != null) ? "User fetched successfully" : "User with email '" + email + "' not found";
        return ResponseEntity.status(dto != null ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(dto, message));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ApiResponse<List<UserDTO>>> findUsersByCategoryId(@PathVariable Integer categoryId) {
        List<UserDTO> users = userGateway.getUsersByCategoryId(categoryId);
        return ResponseEntity.ok(
                new ApiResponse<>(users, users.size() + " users fetched successfully for category ID " + categoryId)
        );
    }

    // ------------------ UPDATE ------------------

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        UserDTO updatedDTO = userGateway.updateUser(userDTO);
        return ResponseEntity.ok(
                new ApiResponse<>(updatedDTO, "'" + updatedDTO + "' has been UPDATED successfully")
        );
    }

    // ------------------ DELETE ------------------

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> deleteUser(@PathVariable int id) {
        UserDTO deletedDTO = userGateway.deleteUser(id);
        return ResponseEntity.ok(
                new ApiResponse<>(deletedDTO, "'" + deletedDTO + "' has been DELETED successfully")
        );
    }
}
