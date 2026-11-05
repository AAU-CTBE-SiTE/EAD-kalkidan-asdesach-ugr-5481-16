package com.craft;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class Address {
    @Value("Addis")
    private String city;

    @Value("Ethiopia")
    private String country;
}