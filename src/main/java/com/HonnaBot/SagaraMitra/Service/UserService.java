package com.HonnaBot.SagaraMitra.Service;

import com.HonnaBot.SagaraMitra.Entity.User;
import com.HonnaBot.SagaraMitra.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByPhone(String phone) {
        return userRepository.findByUserPhone(phone);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
