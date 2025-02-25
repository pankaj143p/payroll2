# Employee Payroll Spring Application

This is an Employee Payroll Application built using **Spring Boot** and **MySQL** that allows you to manage employee payroll details through REST APIs. It supports adding, updating, deleting, and fetching employee details and salaries.

## Features

- **Employee Management**: Add, update, delete, and retrieve employee payroll data.
- **RESTful APIs**: The application exposes REST APIs for handling employee data.
- **Validation**: The application validates data for POST and PUT requests.
- **Database Integration**: Connects to a MySQL database to store employee data.
- **Employee Data**: Handles employee details like `name`, `salary`, `start date`, and `gender`.

## Technologies Used

- **Spring Boot**: For building the backend application.
- **Spring Data JPA**: For database interactions and handling entities.
- **MySQL**: As the relational database management system to store employee data.
- **Spring Validation**: To validate incoming request data.
- **Maven**: For dependency management and building the project.
- **Postman/Curl**: For testing and consuming REST APIs.

## Prerequisites

Before running the application, make sure you have the following software installed:

- **JDK 11 or above** for Java support.
- **MySQL**: Make sure MySQL server is installed and running on your machine.
- **Maven**: For managing project dependencies and building the application.
- **Postman or Curl**: To test REST APIs.

## Setup Instructions

### 1. Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/pankaj143p/payroll2.git
cd employee-payroll-app

