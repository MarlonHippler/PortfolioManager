package com.apple.PortfolioManager.service;


import com.apple.PortfolioManager.model.User;
import com.apple.PortfolioManager.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addEmployee(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepo.save(user);
    }
}
