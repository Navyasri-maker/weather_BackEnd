package com.example.weather.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.weather.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}