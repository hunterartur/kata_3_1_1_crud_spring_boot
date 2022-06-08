package com.arturishmaev.crud_spring_boot.repositories;

import com.arturishmaev.crud_spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getAllStudents();

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    User save(User user);

    void deleteById(Long id);
}
