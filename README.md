# Task Management System

## Introduction

The Task Management System is a backend application designed to handle task management logic and data. It offers a set of RESTful APIs for CRUD operations on tasks and includes features like authentication, authorization, validation, and more.

## Features

- *CRUD Operations*: Create, Read, Update, Delete tasks.
- *Task Details*: Each task has a title, description, status, priority, and due date.
- *Authentication*: JWT-based authentication with Spring Security.
- *Authorization*: User roles (admin, regular user) with enforced access rules.
- *Validation*: Ensures data integrity and consistency.
- *Error Handling*: Provides meaningful error messages.
- *Search and Filter*: Search tasks by various criteria; filter task lists.
- *Email Notifications*: Optional feature for task deadlines and updates.

## Architecture

The application follows a microservices architecture using Spring Boot, with the following components:

- *Controller*: Handles HTTP requests and maps them to appropriate services.
- *Service*: Contains business logic for managing tasks.
- *Repository*: Interacts with the database for CRUD operations.
- *Security*: Implements JWT-based authentication and role-based authorization.

## Setup

### Prerequisites

- Java 17
- Spring Boot
- Maven
- Database (e.g., MySQL)

### Installation

1. **Clone the repository:**
    ```sh
    git clone https://github.com/enno0/Backend_Exercise.git
    cd Backend_Exercise/taskmanagementsystem
    ```

2. **Configure the database:**
    - Update the database settings in `src/main/resources/application.properties`.

3. **Build the application:**
    ```sh
    mvn clean install
    ```

4. **Run the application:**
    ```sh
    mvn spring-boot:run
    ```

### Running Tests

1. **Unit Tests:**
    ```sh
    mvn test
    ```

## API Endpoints

- **Tasks**
  - `GET /tasks`: Retrieve all tasks
  - `GET /tasks/{id}`: Retrieve a specific task
  - `POST /tasks`: Create a new task
  - `PUT /tasks/{id}`: Update a task
  - `DELETE /tasks/{id}`: Delete a task
  - `GET /tasks/search`: Search tasks by criteria

- **Authentication**
  - `POST /auth/login`: User login
  - `POST /auth/register`: User registration

## Database Schema

Include SQL create table statements for Tasks, Users, History, and Notifications.

```sql
CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50),
    priority INT,
    due_date DATE
);

-- Add similar statements for Users, History, and Notifications
