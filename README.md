# Rest-Assured API Testing Framework

A comprehensive API testing framework built with Rest-Assured, TestNG, and Java 21. This framework provides a structured approach to API automation testing with support for database integration, dynamic payload generation, and detailed reporting.

---

## Table of Contents
- [Overview](#overview)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Dependencies](#dependencies)
- [Running Tests](#running-tests)
- [Reporting](#reporting)
- [Contact](#contact)



## Overview

This framework is designed for testing RESTful APIs using the BDD-style syntax provided by Rest-Assured. It follows a modular architecture with separation of concerns, making it easy to maintain and scale.

### Key Features

- **Modular Architecture**: Separated concerns with dedicated packages for requests, payloads, utilities, and tests
- **TestNG Integration**: Leverages TestNG for test execution, assertions, and test configuration
- **Dynamic Data Generation**: Uses JavaFaker for generating realistic test data
- **Allure Reporting**: Comprehensive test reports with Allure integration
- **JSON Schema Validation**: Built-in support for JSON response validation

---
## Project Structure

```
RestAssuredFirstGroup2026/
├── pom.xml                              # Maven configuration file
├── README.md                            # Project documentation
└── src/
    ├── main/
    └── test/
        └── java/
            ├── common/
            │   └── BaseURIs.java            # Base URL configurations
            ├── payloadBuilder/
            │   └── PayloadBuilder.java      # JSON payload builders
            ├── requestBuilder/
            │   └── ApiRequestBuilder.java   # API request methods
            |── tests/
               └── UserRegistrationTest.java# Complete user flow tests
             
```

## Prerequisites

Before setting up the project, ensure you have the following installed:

| Tool | Version | Description |
|------|---------|-------------|
| **JDK** | 21+ | Java Development Kit |
| **Maven** | 3.8+ | Build automation tool |
| **IntelliJ IDEA** | Latest | Recommended IDE |

---
## Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd NdosiAPIInventoryFormAuto

   ```

2. **Import the project**
    - Open IntelliJ IDEA
    - Select `File > Open`
    - Navigate to the project directory and open it
    - IntelliJ will automatically detect the Maven project and download dependencies

3. **Build the project**
   ```bash
   mvn clean install
   ```

---

## Dependencies

The framework uses the following key dependencies:

| Dependency | Version | Purpose |
|------------|---------|---------|
| **Rest-Assured** | 6.0.0 | API testing library |
| **TestNG** | 7.11.0 | Testing framework |
| **JSON Simple** | 1.1.1 | JSON parsing and creation |
| **Gson** | 2.13.0 | JSON serialization/deserialization |
| **Allure TestNG** | 2.29.1 | Test reporting |
| **JavaFaker** | 1.0.2 | Fake data generation |
| **JSON Schema Validator** | 5.5.1 | Response schema validation |

---

## Running Tests

### Using Maven

```bash
# Run all tests
mvn test

# Run a specific test class
mvn test -Dtest=UserRegistrationTest

# Run with clean build
mvn clean test
```

### Using IntelliJ IDEA

1. Right-click on a test class or method
2. Select `Run '<TestName>'`

### Using TestNG XML

Create a `testng.xml` file to configure test suites and run specific tests.

---

## Reporting

### Allure Reports

The framework integrates with Allure for comprehensive test reporting.

1. **Generate Allure results**
   ```bash
   mvn clean test
   ```

2. **Generate and serve report**
   ```bash
   allure serve target/allure-results
   ```

3. **Generate static report**
   ```bash
   allure generate target/allure-results -o target/allure-report
   ```

---

## API Endpoints

The framework is configured to test the following API endpoints:

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/APIDEV/login` | POST | User authentication |
| `/APIDEV/register` | POST | User registration |
| `/APIDEV/admin/users/{id}/approve` | PUT | Approve user registration |

---