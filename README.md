# Patient Management System

> **Note**: This project is currently under active development.

## Overview
Patient Management System is a microservices-based application built with **Spring Boot** (Java 21). It is designed to handle patient records and related billing operations efficiently using modern architectural patterns and **gRPC** for high-performance inter-service communication.

## Architecture
The system is divided into two primary microservices:

### 1. Patient Service (`patient-service`)
- **Port:** 4000
- **Responsibilities:** Manages patient data, handles REST API requests, and stores information in the database.
- **Tech Stack & Libraries:**
  - Spring Boot Web (REST APIs)
  - Spring Data JPA (Data Persistence)
  - PostgreSQL (Primary Database) & H2 (In-memory DB for testing)
  - Validation API
  - Springdoc OpenAPI (Swagger UI for API documentation)
  - gRPC (Client/Server communication)

### 2. Billing Service (`billing-service`)
- **HTTP Port:** 4001
- **gRPC Port:** 9001
- **Responsibilities:** Handles billing logic and receives gRPC calls from the Patient Service.
- **Tech Stack & Libraries:**
  - Spring Boot
  - gRPC (Server)

## Inter-Service Communication
The services communicate with each other using **gRPC** (`grpc-spring-boot-starter` & `protobuf`), ensuring low latency and strongly typed contracts between the `patient-service` and `billing-service`.

## Prerequisites
- Java 21
- Maven
- PostgreSQL (or H2 for local testing)

## Getting Started

1. **Clone the repository**

2. **Build the project**
   Navigate to each service directory and run:
   ```bash
   ./mvnw clean install
   ```
   *This step is crucial as it generates the gRPC stub classes from the `.proto` files using the `protobuf-maven-plugin`.*

3. **Run the microservices**
   - **Billing Service:**
     ```bash
     cd billing-service
     ./mvnw spring-boot:run
     ```
   - **Patient Service:**
     ```bash
     cd patient-service
     ./mvnw spring-boot:run
     ```

4. **API Documentation**
   Once the `patient-service` is running, you can access the Swagger UI documentation at:
   `http://localhost:4000/swagger-ui.html` (if enabled in `application.properties`)

## Testing APIs
A directory named `api-request` contains HTTP files (e.g., `create-patient.http`) that you can use to test the REST endpoints directly from your IDE.

## Future Enhancements
- Full containerization with Docker and Docker Compose.
- Complete implementation of the Billing Service logic.
- Service discovery and centralized configuration.
