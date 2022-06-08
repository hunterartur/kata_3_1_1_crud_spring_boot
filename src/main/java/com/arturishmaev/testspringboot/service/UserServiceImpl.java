package com.arturishmaev.testspringboot.service;

import com.arturishmaev.testspringboot.dao.UserRepository;
import com.arturishmaev.testspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        User user = new User();
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            user = byId.get();
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void updateUserById(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUserById(Long id) {
        userRepository.deleteById(id);
    }

}
