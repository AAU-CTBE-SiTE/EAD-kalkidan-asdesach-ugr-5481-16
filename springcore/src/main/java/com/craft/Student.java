package com.craft;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class Student {
    private int id;
    private String name;
    private int age;

//    public Student() {
//        System.out.println("Student Constructor Called");
//    }

    @Autowired
    public Student(@Value("101") int id,
                   @Value("John Doe") String name,
                   @Value("20") int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        System.out.println("Student Parameterized Constructor Called");
    }

    public void getDetails() {
        System.out.println("Student Details " + this);
    }
}