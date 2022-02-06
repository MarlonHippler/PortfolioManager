package com.apple.PortfolioManager.repo;

import com.apple.PortfolioManager.model.UserApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
@Transactional(readOnly = true)
public interface UserRepo
        extends JpaRepository<UserApp, Long> {

    Optional<UserApp> findByEmail(String email);



}

