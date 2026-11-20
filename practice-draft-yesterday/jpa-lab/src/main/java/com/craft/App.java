package com.craft;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("studentPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void createStudent(Student student) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(student);

        entityManager.getTransaction().commit();
    }

    public static Student getStudentById(int id) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Student.class, id);
    }

    public static void updateStudentName(String newName, int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, id);

        student.setName(newName);
        entityManager.getTransaction().commit();
    }

    public static void updateStudentNameAndTech(String newName, String newTech, int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, id);

        student.setName(newName);
        student.setTech(newTech);
        entityManager.getTransaction().commit();
    }

    public static void deleteStudentById(int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, id);

        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Mohammed ali");
        student1.setTech("Python");

//        createStudent(student1);

        deleteStudentById(2);
        System.out.println(getStudentById(2));
    }
}