# Lab 8: Building a RESTful CRUD API

## Project Information

- **Course:** Enterprise Application Development
- **Laboratory:** Lab 8
- **Branch:** lab-8
- **Project:** Student Management REST API
- **Technology:** Java 17, Spring Boot, Spring Data JPA, Hibernate, MySQL, Maven

## Project Description

This laboratory focuses on developing a RESTful CRUD API using Spring Boot, Spring Data JPA, and MySQL.

The application manages student records and provides REST endpoints to create, retrieve, update, and delete student information.

## Implemented Features

The following operations have been implemented and manually tested:

- Create a student (POST)
- Retrieve all students (GET)
- Retrieve a student by ID (GET)
- Update student information (PUT)
- Delete a student (DELETE)

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL 8
- Maven
- Git and GitHub
- PowerShell for API testing

## API Endpoints

Base URL: `http://localhost:8080/api/students`

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/api/students` | Create a student |
| GET | `/api/students` | Retrieve all students |
| GET | `/api/students/{id}` | Retrieve a student by ID |
| PUT | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Delete a student |

## Database Configuration

The application uses MySQL for data persistence.

Database connection settings are configured through environment variables:

- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`

Default database URL: `jdbc:mysql://localhost:3306/studentdb`

## Development Status

**Status: IN PROGRESS - NOT YET COMPLETED**

The basic CRUD functionality has been implemented and tested successfully using PowerShell.

However, the laboratory project is still under development. Further review, verification, documentation, and completion of the remaining laboratory requirements are pending.

This repository represents the current development progress and should not be considered the final submission.

## Development History

The development process was documented through the following ChatGPT conversation:

[View Lab 8 Development History](https://chatgpt.com/share/6afecc26-e21c-83ea-bb74-134686eea9f6)

## Author

Kalkidan Asdesach

## Note

This README documents the current state of Lab 8. It will be updated as the project progresses and the remaining laboratory requirements are completed.
