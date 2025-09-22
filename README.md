# RestAssured API Testing Framework

## Overview
This project is an **API automation framework** using **Rest Assured**, **TestNG**, and **Maven** for testing the [Reqres.in](https://reqres.in/) public API.  
It demonstrates CRUD operations (Create, Read, Update, Delete), authentication handling, data-driven testing, and JSON schema validation.

## Project Structure
RestAssuredProject
│
├─ pom.xml
├─ README.md
├─ src
│ ├─ main
│ │ └─ java
│ │ └─ (empty)
│ └─ test
│ ├─ java
│ │ └─ tests
│ │ ├─ BaseTest.java
│ │ ├─ GetUserTest.java
│ │ ├─ CreateUserTest.java
│ │ ├─ UpdateUserTest.java
│ │ ├─ DeleteUserTest.java
│ │ ├─ CreateUserDataDrivenTest.java
│ │ ├─ CreateUserExcelDataDrivenTest.java
│ │ ├─ BasicAuthTest.java
│ │ └─ BearerAuthTest.java
│ │
│ └─ utils
│ └─ ExcelUtils.java
│
└─ resources
├─ getUserSchema.json
├─ userData.xlsx
└─ config.properties (excluded in .gitignore for security)

## Features

- **CRUD Operations**
  - `GET /users` → Retrieve user details  
  - `POST /users` → Create new user  
  - `PUT /users/{id}` → Update existing user  
  - `DELETE /users/{id}` → Delete user  

- **Authentication Testing**
  - Basic Auth  
  - Bearer Token / API key (query parameter)  

- **Data-Driven Testing**
  - JSON and Excel-based test data  
  - Supports multiple test cases from a single template  

- **Assertions**
  - Status code validation  
  - Response body validation  
  - Header validation  
  - Response time checks  

- **JSON Schema Validation**
  - Ensures correct API response structure  

- **Maven & TestNG Integration**
  - Run all tests with Maven Surefire plugin  
  - Supports test grouping and parallel execution

## Getting Started

### Prerequisites
- Java JDK 11 or higher  
- Maven 3.x  
- IntelliJ IDEA / Eclipse (or any Java IDE)  
- Git (for version control)  

### Setup
1. Clone the repository:
    git clone https://github.com/MonaKumari08/RestAssuredProject.git
2. Navigate to project folder:
    cd RestAssuredProject
3. Add your API key in src/test/resources/config.properties:
    **api.key**=YOUR_FREE_API_KEY_HERE
    **base.url**=https://reqres.in/api
Note: config.properties is ignored in Git for security.

### Dependencies
1. Rest Assured → API testing library
2. TestNG → Test framework
3. Maven → Build tool
4. Apache POI → Excel data handling
   
### Author
Mona Kumari
QA Engineer | API Automation Enthusiast

**License**
This project is open-source for educational purposes.

