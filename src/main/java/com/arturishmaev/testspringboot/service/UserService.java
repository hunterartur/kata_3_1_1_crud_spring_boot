package com.arturishmaev.testspringboot.service;


import com.arturishmaev.testspringboot.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> getAllUsers();
    User getUserById(Long id);
    void updateUserById(User user);

    void removeUserById(Long id);

}
