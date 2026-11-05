package com.craft;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class Student {
    private int id;
    private String name;
    private int age;

    public void getDetails() {
        System.out.println("Student Details " + this);
    }
}