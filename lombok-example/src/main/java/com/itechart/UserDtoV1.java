package com.itechart;

import lombok.AccessLevel;
import lombok.Setter;

import java.util.Objects;

public class UserDtoV1 {

    private Long id;
    private String name;
    private String lastName;
    private Integer age;

    public UserDtoV1() {
    }

    public UserDtoV1(Long id, String name, String lastName, Integer age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDtoV1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDtoV1 userDtoV1 = (UserDtoV1) o;
        return Objects.equals(id, userDtoV1.id) && Objects.equals(name, userDtoV1.name) && Objects.equals(lastName, userDtoV1.lastName) && Objects.equals(age, userDtoV1.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, age);
    }
}
