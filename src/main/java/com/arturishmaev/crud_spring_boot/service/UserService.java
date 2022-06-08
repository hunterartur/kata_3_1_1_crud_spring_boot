package com.arturishmaev.crud_spring_boot.service;

import com.arturishmaev.crud_spring_boot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllStudents();

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    User save(User user);

    void deleteById(Long id);

}
