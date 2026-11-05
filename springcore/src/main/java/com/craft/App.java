package com.craft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(AppConfig.class);

        Student student = context.getBean("student", Student.class);

        student.setId(101);
        student.setName("John");
        student.setAge(34);

        student.getDetails();

    }
}