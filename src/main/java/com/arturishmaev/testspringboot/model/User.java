package com.arturishmaev.testspringboot.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "The field should not be empty!")
    @Size(min = 2, max = 255, message = "Minimum two simbols!")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "The field should not be empty!")
    @Column(name = "lastname")
    private String lastname;

    @Min(value = 18, message = "Minimum 18!")
    @Column(name = "age")
    private byte age;

    @NotEmpty(message = "The field should not be empty!")
    @Column(name = "hobby")
    private String hobby;


    @Column(name = "sex")
    private Sex sex;

    public User() {
    }

    public User(String name, String lastname, byte age, String hobby, Sex sex) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.hobby = hobby;
        this.sex = sex;
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

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                ", sex=" + sex +
                '}';
    }
}
