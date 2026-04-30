# Dorothy's Massage Studio API

Spring Boot backend API for Dorothy's Massage Studio.

This backend supports the Dorothy's Massage Studio website by moving business content and studio hours out of the React frontend and into a structured backend service backed by PostgreSQL.

## Overview

The goal of this project is to build a maintainable backend API for managing business information, business hours, services, scheduling-related data, and future admin features.

The current development phase focuses on building clean backend slices for business information and business hours, including entity modeling, repository access, service logic, DTO mapping, seed data, and REST endpoints.

## Current Features

- Spring Boot backend setup
- PostgreSQL database connection
- Spring Data JPA integration
- BusinessInfo JPA entity
- BusinessHour JPA entity
- One-to-many relationship between BusinessInfo and BusinessHour
- BusinessInfo repository layer
- BusinessInfo service layer
- DTO mapping for API responses
- REST controller for business information
- Seed data for business information and studio hours
- Local development configuration using environment variables in `application.yaml`

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
- `dto/` contains API response objects
- `mapper/` contains conversion logic between entities and DTOs
- `service/` contains business logic
- `controller/` exposes REST API endpoints
- `config/` contains startup and configuration classes such as seed data

## Current Backend Slice

The current API exposes business information and business hours through:

```text
GET /api/business-info
```

This endpoint currently returns:

- business name
- phone display text
- phone link
- address lines
- homepage intro title
- homepage intro paragraphs
- studio hours

This allows the React frontend to fetch business content from the backend instead of storing all business information directly in frontend files.

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

> Note: Credentials should be supplied through environment variables for local development and deployment.

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

- Move services and pricing data into the backend
- Additional API slices for service offerings and content management
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

This project is actively being built in phases. The current focus is learning and implementing clean backend slices one domain at a time, then integrating them into the frontend.

## Author

Built and maintained by Raymond Yu.
