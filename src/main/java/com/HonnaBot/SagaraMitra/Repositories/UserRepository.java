package com.HonnaBot.SagaraMitra.Repositories;

import com.HonnaBot.SagaraMitra.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {

    User findByUserPhone(String userPhone);
}
