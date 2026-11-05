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
    @Value("101")
    private int id;

    @Value("John Doe")
    private String name;

    @Value("20")
    private int age;

//    private String city;
//    private String country;

    @Autowired
    private Address address;

}