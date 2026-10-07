package com.example.weather_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.weather_backend.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}