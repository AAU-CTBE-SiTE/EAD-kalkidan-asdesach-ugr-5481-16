package com.craft;

import lombok.Data;
import lombok.ToString;
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

    @Value("Addis")
    private String city;

    @Value("Ethiopia")
    private String country;

}