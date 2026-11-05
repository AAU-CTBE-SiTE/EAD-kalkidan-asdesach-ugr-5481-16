package com.craft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.craft")
public class AppConfig {

    @Bean("math")
    public Subject math() {
        Subject subject = new Subject();
        subject.setSubjectName("Maths 101");
        return subject;
    }

    @Bean("Java")
    public Subject java() {
        Subject subject = new Subject();
        subject.setSubjectName("Java EE");
        return subject;
    }
}