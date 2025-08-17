package com.HonnaBot.SagaraMitra.controller;

import com.HonnaBot.SagaraMitra.Entity.User;
import com.HonnaBot.SagaraMitra.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/check-user")
    public Map<String, Boolean> checkUserExists(@RequestParam String userPhone) {
        boolean exists = userService.checkUserExists(userPhone);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return response;
    }

    @PostMapping("/login")
    public Map<String, String> loginUser(@RequestBody Map<String, String> loginRequest) {
        String userPhone = loginRequest.get("userPhone");
        String userPassword = loginRequest.get("userPassword");

        Map<String, String> response = new HashMap<>();
        String status = userService.validateUserLogin(userPhone, userPassword);
        response.put("status", status);
        return response;
    }

    @PostMapping("/logout")
    public String logoutUser() {
        userService.logoutUser();
        return "Logged out successfully!";
    }

    @GetMapping("/current-user")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    // ✅ Forgot password: generate OTP
    @PostMapping("/forgot-password")
    public Map<String, String> forgotPassword(@RequestBody Map<String, String> request) {
        String userName = request.get("userName");
        String userPhone = request.get("userPhone");

        Map<String, String> response = new HashMap<>();
        String otp = userService.generateOtp(userName, userPhone);

        if (otp != null) {
            response.put("status", "success");
            response.put("otp", otp); // In real app, send via SMS/email
        } else {
            response.put("status", "error");
            response.put("message", "No matching user found with provided Name and Phone.");
        }
        return response;
    }

    // ✅ Reset password using OTP
    @PostMapping("/reset-password")
    public Map<String, String> resetPassword(@RequestBody Map<String, String> request) {
        String userPhone = request.get("userPhone");
        String otp = request.get("otp");
        String newPassword = request.get("newPassword");

        Map<String, String> response = new HashMap<>();
        boolean success = userService.resetPassword(userPhone, otp, newPassword);

        if (success) {
            response.put("status", "success");
            response.put("message", "Password reset successfully!");
        } else {
            response.put("status", "error");
            response.put("message", "Invalid OTP. Please try again.");
        }
        return response;
    }
}
