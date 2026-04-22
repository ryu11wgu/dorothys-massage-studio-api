# Dorothy's Massage Studio API

Spring Boot backend API for Dorothy's Massage Studio.

This backend is being developed to support the Dorothy's Massage Studio website by moving business content and future business workflows out of the React frontend and into a structured backend service.

## Overview

The goal of this project is to build a maintainable backend API for managing business information, services, scheduling-related data, and future admin features.

The first development phase focuses on creating a clean backend slice for business information, including the entity, repository, DTO, mapper, and service layers.

## Current Features

- Spring Boot backend setup
- PostgreSQL database connection
- Spring Data JPA integration
- BusinessInfo JPA entity
- BusinessInfo repository layer
- BusinessInfo response DTO
- BusinessInfo mapper
- BusinessInfo service layer
- Local development configuration using `application.yaml`

## Tech Stack

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok
- Jakarta Validation

## Project Structure

```text
src/main/java/com/raymond/dorothysmassagestudio/
  config/
  controller/
  dto/
  mapper/
  model/
  repository/
  service/
```

### Structure Notes

- `model/` contains JPA entities that represent database tables
- `repository/` contains Spring Data JPA repositories for database access
- `dto/` contains API request/response objects
- `mapper/` contains conversion logic between entities and DTOs
- `service/` contains business logic
- `controller/` will expose REST API endpoints
- `config/` will contain application configuration classes as needed

## Current Backend Slice

The current slice being built is for business information.

```text
BusinessInfo Entity
      ↓
BusinessInfoRepository
      ↓
BusinessInfoService
      ↓
BusinessInfoResponse DTO
      ↓
Future REST Controller
```

This will eventually support an endpoint such as:

```text
GET /api/business-info
```

The React frontend can then fetch business content from the backend instead of storing all business information directly in frontend files.

## Database

The application is configured to connect to a local PostgreSQL database.

Example local configuration:

```yaml
spring:
  datasource:
    url: ${DB_URL:jdbc:postgresql://localhost:5432/dorothys_massage_studio}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

> Note: Local credentials are for development only. Production credentials should be managed securely with environment variables or deployment platform secrets.

## Running Locally

### Prerequisites

- Java 21
- PostgreSQL
- Maven wrapper included in the project

### Start the application

```bash
./mvnw spring-boot:run
```

By default, the backend runs on:

```text
http://localhost:8080
```

## Planned Features

- REST controller for business information
- Seed initial business data
- API integration with the React frontend
- Service and pricing management
- Business hours management
- Booking request workflow
- Admin panel support
- Authentication and protected admin routes
- Future AI assistant integration

## Related Project

This API is intended to support the Dorothy's Massage Studio React frontend.

Frontend repository:

```text
dorothysmassagestudio
```

## Development Status

This project is actively being built in phases. The current focus is learning and implementing one clean backend slice at a time before expanding into larger features such as booking, admin management, and frontend integration.

## Author

Built and maintained by Raymond Yu.
