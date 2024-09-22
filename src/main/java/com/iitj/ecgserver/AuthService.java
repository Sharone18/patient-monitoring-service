package com.iitj.ecgserver;

import com.iitj.ecgserver.entity.Login;
import com.iitj.ecgserver.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private LoginRepository loginRepository;

    public boolean authenticate(String username, String password) {
        Login user = loginRepository.findByUserId(username);
        System.out.println(user.getPassword() + "   " + user.getUserId());
        // Ideally, use password hashing and check against hashed password
        return user != null && user.getPassword().equals(password); // Authentication successful
    }
}
