package com.craft;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class Student {
    private int id;
    private String name;
    private int age;

    @Value("101")
    public void setId(int id) {
        this.id = id;
    }

    @Value("John Doe")
    public void setName(String name) {
        this.name = name;
    }

    @Value("20")
    public void setAge(int age) {
        this.age = age;
    }

    public void getDetails() {
        System.out.println("Student Details " + this);
    }
}