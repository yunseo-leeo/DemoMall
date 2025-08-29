package com.example.mall.repository;

import com.example.mall.domain.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
    Optional<User> findByUser(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
}
