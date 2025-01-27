## Customer Management Application

This is a Spring Boot application for managing customer details with validation and exception handling.

### Features

* Create and retrieve customer details
* Field validations (firstName, lastName, dateOfBirth)
* Custom exception handling
* In-memory storage using ConcurrentHashMap
* Comprehensive unit tests
* RESTful API endpoints

### Tech Stack

* Java 17
* Spring Boot 3.x
* JUnit 5
* Mockito
* Maven

### Project Structure


[Uploading Screenshot 2025-01-27 at 6.24.02 PM.png…]()

### Prerequisites

* Java 17 or higher
* Maven 3.6.x or higher
* Git

### Getting Started

1. Clone the repository:

```bash
git clone [invalid URL removed]
cd customer-management

2. Build the project:

```bash
mvn clean install

3.Run the application:
```bash
mvn spring-boot:run

The application will start on http://localhost:8080.


API Endpoints
Create Customer (POST /api/customers):

Content-Type: application/json
Request Body:
```bash
{
  "firstName": "John",
  "lastName": "Doe",
  "dateOfBirth": "1990-01-01"
}


Get Customer (GET /api/customers/{customerId})


Running Tests
Run unit tests:
```bash
mvn test

Git Setup Instructions
Initialize Git repository (if not already done):
```bash
git init

Create a .gitignore file with the following content:
```bash
.mvn/wrapper/maven-wrapper.jar
**/src/main/**/target/
**/src/test/**/target/

# IDE specific ignores
### STS ###
.apt_generated.classpath.factorypath.project.settings.springBeans.sts4-cache

### IntelliJ IDEA ###
.idea*
*.iws
*.iml
*.ipr

### VS Code ###
.vscode/

# Logs
*.log


Add files and make initial commit:
```bash
git add .
git commit -m "Initial commit: Customer Management Application"


Link to remote repository:
```bash
git remote add origin [invalid URL removed]
git branch -M main
git push -u origin main


Project Configuration
application.properties:
```bash
server.port=8080
spring.application.name=customer-management

2.0 Flash Experimental. Might not work as expected.
Absolutely, here's the markdown code for the Customer Management Application you described:

Markdown

## Customer Management Application

This is a Spring Boot application for managing customer details with validation and exception handling.

### Features

* Create and retrieve customer details
* Field validations (firstName, lastName, dateOfBirth)
* Custom exception handling
* In-memory storage using ConcurrentHashMap
* Comprehensive unit tests
* RESTful API endpoints

### Tech Stack

* Java 17
* Spring Boot 3.x
* JUnit 5
* Mockito
* Maven

### Project Structure

customer-management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/customer/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       └── exception/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/customer/
│               ├── controller/
│               ├── service/
│               └── repository/
└── pom.xml


### Prerequisites

* Java 17 or higher
* Maven 3.6.x or higher
* Git

### Getting Started

1. Clone the repository:

```bash
git clone [invalid URL removed]
cd customer-management
Build the project:
Bash

mvn clean install
Run the application:
```bash

mvn spring-boot:run
The application will start on http://localhost:8080.

API Endpoints
Create Customer (POST /api/customers):

Content-Type: application/json
Request Body:
```bash
JSON

{
  "firstName": "John",
  "lastName": "Doe",
  "dateOfBirth": "1990-01-01"
}
Get Customer (GET /api/customers/{customerId})

Running Tests
Run unit tests:

```bash

mvn test
Git Setup Instructions
Initialize Git repository (if not already done):
```bash

git init
Create a .gitignore file with the following content:
.mvn/wrapper/maven-wrapper.jar
**/src/main/**/target/
**/src/test/**/target/

# IDE specific ignores
### STS ###
.apt_generated.classpath.factorypath.project.settings.springBeans.sts4-cache

### IntelliJ IDEA ###
.idea*
*.iws
*.iml
*.ipr

### VS Code ###
.vscode/

# Logs
*.log
Add files and make initial commit:
```bash

git add .
git commit -m "Initial commit: Customer Management Application"
Link to remote repository:
```bash

git remote add origin [invalid URL removed]
git branch -M main
git push -u origin main
Project Configuration
application.properties:

Properties
```bash
server.port=8080
spring.application.name=customer-management


pom.xml Dependencies:
```bash
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>


Error Handling
The application includes comprehensive error handling for:

Invalid input validation
Customer not found
Customer creation failures
General system errors
Contributing
Fork the repository
Create your feature branch
Commit your changes
Push to the branch
Open a Pull Request









