package com.arturishmaev.crud_spring_boot.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "The field should not be empty!")
    @Size(min = 2, message = "At least 2 letters!")
    @Column(name = "name")
    private String name;

    @NotNull(message = "The field should not be empty!")
    @Column(name = "lastname")
    private String lastname;

    @Min(18)
    @Max(120)
    @Column(name = "age")
    private int age;

    @NotNull(message = "The field should not be empty!")
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(String name, String lastname, int age, String email) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}


