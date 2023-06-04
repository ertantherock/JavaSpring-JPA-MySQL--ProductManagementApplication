# JavaSpring-JPA-MySQL-ProductManagementApplication

This repository contains a Product Management Application developed using Java Spring Boot, JPA, and MySQL. The application allows users to manage products by performing various CRUD (Create, Read, Update, Delete) operations.

## Prerequisites

To run this application locally, you'll need to have the following installed on your machine:

- Java Development Kit (JDK) 8 or above
- Apache Maven
- MySQL Server

## Getting Started

To get started with the Product Management Application, follow these steps:

1. Clone this repository to your local machine using the following command:

   ```bash
   git clone https://github.com/ertantherock/JavaSpring-JPA-MySQL--ProductManagementApplication.git


## Code Structure

The codebase follows a typical Java Spring Boot project structure. Here's a brief overview of the main directories and files:

- `src/main/java`: Contains the Java source code files for the application.
  - `com.example.product`: The root package for the application.
    - `config`: Contains configuration classes for the application.
    - `controller`: Contains the controller classes responsible for handling HTTP requests and responses.
    - `model`: Contains the entity classes that represent the data model of the application.
    - `repository`: Contains the repository interfaces for interacting with the database using JPA.
    - `service`: Contains the service classes that implement the business logic of the application.
    - `ProductManagementApplication.java`: The main entry point for the application.
- `src/main/resources`: Contains the application resources such as configuration files and static content.
  - `application.properties`: The configuration file where you can specify the database connection details and other application-specific properties.
- `src/test`: Contains the unit tests for the application.

## Architecture

The Product Management Application follows a layered architecture pattern, separating different concerns into distinct layers. Here's an overview of the architecture:

- **Presentation Layer**: The presentation layer handles the user interface and user interactions. In this application, the presentation layer is implemented using Spring MVC and the controller classes. The controllers receive incoming HTTP requests, handle them, and return the appropriate HTTP responses.

- **Service Layer**: The service layer contains the business logic of the application. It encapsulates the operations that can be performed on the data model. The service classes handle the communication between the presentation layer and the data access layer. They apply business rules, perform validations, and coordinate data access operations.

- **Data Access Layer**: The data access layer is responsible for interacting with the database. It uses the Java Persistence API (JPA) to perform CRUD operations on the underlying MySQL database. The repository interfaces define the contract for data access and are implemented by the JPA provider.

- **Database**: The application uses MySQL as the database to store and retrieve product data. The `application.properties` file contains the necessary configuration for connecting to the MySQL database.

