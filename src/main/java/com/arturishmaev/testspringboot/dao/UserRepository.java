package com.arturishmaev.testspringboot.dao;

import com.arturishmaev.testspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
