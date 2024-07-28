# Task Management System

This project is a Task Management System built using Spring Boot. The application provides functionalities for managing users, roles, and tasks, with support for authentication and dynamic task filtering. Below is an overview of the project's architecture and implementation.

## Table of Contents

- [Project Structure](#project-structure)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Missing Points and TODOs](#missing-points-and-todos)
- [Contribution](#contribution)
- [License](#license)
- [Contact](#contact)

## Project Structure

src/main/java/com/backend_xeercise/taskmanagementsystem
├── controllers
│ ├── TaskController.java
│ ├── UserController.java
│ └── UserRoleController.java
├── dataaccessopject
│ ├── TasksAccOp.java
│ ├── UsersAccOp.java
│ └── UserRoleAccessOpj.java
├── datatransferopject
│ ├── LoginRequest.java
│ ├── TasksTransferOpject.java
│ └── UsersTransferOp.java
├── models
│ ├── Tasks.java
│ ├── Users.java
│ └── UserRole.java
├── security
│ └── SecurityConfig.java
├── service
│ ├── CustomUserDetailsService.java
│ ├── EmailService.java
│ ├── TasksCRUD.java
│ ├── UsersCRUD.java
│ └── UserRoleCRUD.java
├── specification
│ ├── TaskSpecifications.java
│ └── TasksSpecification.java
└── TaskManagementSystemApplication.java
resources
├── application.properties
└── templates
├── login.html
├── tasks.html
└── users.html