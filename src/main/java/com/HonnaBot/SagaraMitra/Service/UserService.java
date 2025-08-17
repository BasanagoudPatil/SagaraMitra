package com.HonnaBot.SagaraMitra.Service;

import com.HonnaBot.SagaraMitra.Entity.User;
import com.HonnaBot.SagaraMitra.Repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    private Map<String, String> otpStorage = new HashMap<>(); // Temporary OTP storage

    public String registerUser(User user) {
        if (userRepository.existsByUserPhone(user.getUserPhone())) {
            return "Phone number already registered!";
        }
        userRepository.save(user);
        return "User registered successfully!";
    }

    public boolean checkUserExists(String userPhone) {
        return userRepository.existsByUserPhone(userPhone);
    }

    public String validateUserLogin(String userPhone, String userPassword) {
        User user = userRepository.findByUserPhone(userPhone);
        if (user == null) return "not_found";
        if (!user.getUserPassword().equals(userPassword)) return "wrong_password";
        session.setAttribute("user", user);
        return "success";
    }

    public void logoutUser() {
        session.invalidate();
    }

    public User getCurrentUser() {
        return (User) session.getAttribute("user");
    }

    // ✅ Generate OTP for forgot password
    public String generateOtp(String userName, String userPhone) {
        User user = userRepository.findByUserPhone(userPhone);
        if (user == null || !user.getUserName().equalsIgnoreCase(userName)) {
            return null; // No match
        }

        // Generate 6-digit OTP
        Random random = new Random();
        String otp = String.format("%06d", random.nextInt(1000000));
        otpStorage.put(userPhone, otp); // store OTP temporarily

        return otp; // In real app, send via SMS/email
    }

    // ✅ Reset password using OTP
    public boolean resetPassword(String userPhone, String otp, String newPassword) {
        String storedOtp = otpStorage.get(userPhone);
        if (storedOtp == null || !storedOtp.equals(otp)) {
            return false; // Invalid OTP
        }
        User user = userRepository.findByUserPhone(userPhone);
        user.setUserPassword(newPassword);
        userRepository.save(user);
        otpStorage.remove(userPhone); // remove used OTP
        return true;
    }
}
