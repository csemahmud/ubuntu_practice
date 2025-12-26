/**
 * 
 */
package com.khan.LogInMySQL2508App.dto;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */
public class LoginResponseDTO {

    private String token;
    private String message;
    private Long userId;
    private String name;

    // ✅ Constructor
    public LoginResponseDTO(String token, String message, Long userId, String name) {
        this.token = token;
        this.message = message;
        this.userId = userId;
        this.name = name;
    }

    // ✅ Getters & setters
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
