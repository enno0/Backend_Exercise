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

## Project Structure

- `src/main/java/com/banquemisr/challenge05/taskmanagementsystem`
  - `controllers`
    - `TaskController.java`
    - `UserController.java`
    - `UserRoleController.java`
  - `dataaccessopject`
    - `TasksAccOp.java`
    - `UsersAccOp.java`
    - `UserRoleAccessOpj.java`
  - `datatransferopject`
    - `LoginRequest.java`
    - `TasksTransferOpject.java`
    - `UsersTransferOp.java`
  - `models`
    - `Tasks.java`
    - `Users.java`
    - `UserRole.java`
  - `security`
    - `SecurityConfig.java`
  - `service`
    - `CustomUserDetailsService.java`
    - `EmailService.java`
    - `TasksCRUD.java`
    - `UsersCRUD.java`
    - `UserRoleCRUD.java`
  - `specification`
    - `TaskSpecifications.java`
    - `TasksSpecification.java`
  - `TaskManagementSystemApplication.java`

- `resources`
  - `application.properties`
  - `templates`
    - `login.html`
    - `tasks.html`
    - `users.html`
resources
→ application.properties
→ templates
  → login.html
  → tasks.html
  → users.html


## Features

- **User Management**: Create, update, delete, and retrieve user information.
- **Role Management**: Assign roles to users, manage roles.
- **Task Management**: Create, update, delete, and retrieve tasks.
- **Authentication and Authorization**: Secure endpoints with role-based access control.
- **Email Notifications**: Send email notifications (commented out in configuration).
- **Dynamic Task Filtering**: Filter tasks based on title, description, and status.
- **Custom Annotations**: Validate fields with custom annotations.

## Technologies Used

- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **Hibernate**
- **Lombok**
- **MySQL**

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/taskmanagementsystem.git
   cd taskmanagementsystem

2. Configure the database:   
   Update the 'application.properties' file with your database credentials.

3. Configure the database:   
   mvn clean install

3. Run the application:
   mvn spring-boot:run

## Configuration   
Update the application.properties file with the following configurations:

spring.application.name=taskmanagementsystem

# Database Configuration
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3307/kamal?useSSL=false
spring.datasource.username=kamal
spring.datasource.password=work123

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true

# View Resolver Configuration
spring.mvc.view.prefix=/resources/templates
spring.mvc.view.suffix=.html

# DEBUG
logging.level.org.springframework=DEBUG

# Configure Mail Properties (currently inactive)
- spring.mail.host=smtp.gmail.com
- spring.mail.port=587
- spring.mail.username=your-email@gmail.com
- spring.mail.password=your-email-password
- spring.mail.properties.mail.smtp.auth=true
- spring.mail.properties.mail.smtp.starttls.enable=true
- spring.mail.properties.mail.smtp.starttls.required=true
- spring.mail.properties.mail.smtp.ssl.trust=smtp.gmail.com

## Usage

1. Access the application: Open a web browser and navigate to http://localhost:8080.

2. Login: Use the login page to authenticate. Default credentials can be set up in the
   database.

3. Manage Users and Roles:Use the provided endpoints to manage users and roles.

4. Manage Tasks:Create, update, delete, and filter tasks using the available endpoints.


## Endpoints

### Web Controllers

#### AuthControllerWeb.java
- `GET /`: Home page.
- `GET /login`: Login page.
- `GET /access-denied`: Access denied page.
- `GET /logout`: Logout and redirect to logout success page.
- `GET /logout-success`: Logout success page.

#### TasksController.java
- `GET /web/tasks/add`: Add task form.
- `POST /web/tasks/add`: Create task.
- `GET /web/tasks/update/{id}`: Update task form.
- `POST /web/tasks/update/{id}`: Update task.
- `GET /web/tasks/delete/{id}`: Delete task.
- `GET /web/tasks/allTasks`: View all tasks.

#### UsersWebController.java
- `GET /web/users/allUsers`: View all users.
- `GET /web/users/add`: Add user form.
- `POST /web/users/add`: Create user.
- `GET /web/users/update/{id}`: Update user form.
- `POST /web/users/update/{id}`: Update user.
- `GET /web/users/delete/{id}`: Delete user.

#### UserRoleController.java
- `GET /web/userRole`: View all user roles.
- `GET /web/userRole/{id}`: View user role by ID.
- `GET /web/userRole/add`: Add user role form.
- `POST /web/userRole/add`: Create user role.
- `GET /web/userRole/update/{id}`: Update user role form.
- `POST /web/userRole/update/{id}`: Update user role.
- `GET /web/userRole/delete/{id}`: Delete user role.

### REST Controllers

#### AuthController.java
- `POST /api/auth`: Authenticate user.

#### EmailController.java
- `GET /send-email`: Send email.

#### UsersRestController.java
- `GET /api/users`: Get all users.
- `GET /api/users/{id}`: Get user by ID.
- `POST /api/users`: Create user.
- `PUT /api/users/{id}`: Update user.
- `DELETE /api/users/{id}`: Delete user.

#### UserRoleRestController.java
- `GET /api/userRole`: Get all user roles.
- `GET /api/userRole/{id}`: Get user role by ID.
- `POST /api/userRole`: Create user role.
- `PUT /api/userRole/{id}`: Update user role.
- `DELETE /api/userRole/{id}`: Delete user role.

#### TasksRestController.java
- `GET /api/tasks/byTitle`: Get tasks by title.
- `GET /api/tasks/byDescription`: Get tasks by description.
- `GET /api/tasks/byStatus`: Get tasks by status.
- `GET /api/tasks/search`: Search tasks.
- `GET /api/tasks`: Get all tasks.
- `GET /api/tasks/{id}`: Get task by ID.
- `POST /api/tasks`: Create task.
- `PUT /api/tasks/{id}`: Update task.
- `DELETE /api/tasks/{id}`: Delete task.
