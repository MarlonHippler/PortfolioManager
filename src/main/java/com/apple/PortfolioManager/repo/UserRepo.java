package com.apple.PortfolioManager.repo;

import com.apple.PortfolioManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
