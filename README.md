# Dorothy's Massage Studio API

Backend API for Dorothy's Massage Studio, a client-facing business website developed and maintained for a massage therapy practice.

This Spring Boot API supports the Dorothy's Massage Studio frontend by serving structured business information and studio hours from a PostgreSQL-backed backend service. The project is designed as the backend foundation for a maintainable full-stack website that can expand into content management, scheduling, admin tools, and additional business workflow features.

## Project Status

This project is actively maintained and currently provides backend data for the Dorothy's Massage Studio website.

The current implementation includes a business information API slice with database-backed business profile content, studio hours, DTO-based API responses, seed data, and CORS configuration for the deployed frontend.

## Related Project

Frontend repository:

```text
https://github.com/ryu11wgu/dorothysmassagestudio.git
```

Live website:

```text
https://dorothysmassagestudio.com
```

## Overview

The API currently provides business information and studio hours to the React frontend. This allows important business content to be managed through a backend service instead of being stored entirely in frontend files.

The backend follows a layered Spring Boot structure:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
JPA Entities
    ↓
PostgreSQL
```

DTOs and mapper classes are used to shape API responses before they are returned to the frontend.

## Current Features

* Spring Boot backend API
* PostgreSQL database connection
* Spring Data JPA integration
* Business information domain model
* Studio hours domain model
* One-to-many relationship between `BusinessInfo` and `BusinessHour`
* Element collections for address lines and homepage intro paragraphs
* Repository layer for database access
* Service layer for business logic
* DTO records for API response modeling
* Mapper class for converting entities into API responses
* REST endpoint for business information and studio hours
* Startup seed data for initial business content
* CORS configuration for local development and deployed frontend domains
* Environment-based configuration for database credentials and server port
* Dockerfile for containerized builds and deployment

## Tech Stack

* Java 21
* Spring Boot
* Spring Web MVC
* Spring Data JPA
* PostgreSQL
* Maven
* Maven Wrapper
* Lombok
* Jakarta Validation
* Docker

## API Endpoint

### Get Business Information

```http
GET /api/business-info
```

Returns business profile information and studio hours for the frontend.

Example response shape:

```json
{
  "id": 1,
  "name": "Dorothy's Massage Studio",
  "phoneDisplay": "(661) 405-4079",
  "phoneHref": "tel:+16614054079",
  "addressLines": [
    "1034 W Ave L 12",
    "Suite 101 Room #5",
    "Lancaster, CA 93534"
  ],
  "homeIntroTitle": "Therapeutic care with over 25 years of experience",
  "homeIntroParagraphs": [
    "Book your appointment with Dorothy, a seasoned massage therapist and healing practitioner with over 25 years of experience.",
    "Since 1996, she has offered mindful, intuitive touch-customized treatments designed to calm the nervous system, release tension, and revitalize both body and mind.",
    "Sessions are designed to support the body's natural healing process."
  ],
  "businessHours": [
    {
      "id": 1,
      "day": "Monday",
      "hours": "8:00 am - 10:00 pm",
      "displayOrder": 1
    }
  ]
}
```

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
  DorothysMassageStudioApiApplication.java

src/main/resources/
  application.yaml
  application-example.yaml

src/test/java/com/raymond/dorothysmassagestudio/
  DorothysMassageStudioApiApplicationTests.java
```

## Structure Notes

* `config/` contains application configuration classes, including seed data and CORS configuration.
* `controller/` exposes REST API endpoints.
* `dto/` contains API response records returned to the frontend.
* `mapper/` contains conversion logic between JPA entities and DTO responses.
* `model/` contains JPA entities that represent database tables and relationships.
* `repository/` contains Spring Data JPA repositories for database access.
* `service/` contains application business logic.
* `application.yaml` contains environment-based runtime configuration.
* `application-example.yaml` provides an example local configuration template.

## Domain Model

### BusinessInfo

The `BusinessInfo` entity stores core business profile content, including:

* Business name
* Display phone number
* Click-to-call phone link
* Address lines
* Homepage intro title
* Homepage intro paragraphs
* Related business hours

### BusinessHour

The `BusinessHour` entity stores studio hours connected to a `BusinessInfo` record.

Each business hour includes:

* Day
* Hours text
* Display order
* Parent business information record

## Database

The application uses PostgreSQL.

The configured datasource values are read from environment variables:

```yaml
spring:
  datasource:
    url: ${DB_URL}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true

server:
  port: ${PORT:8080}
```

### Required Environment Variables

```text
DB_URL=jdbc:postgresql://localhost:5432/dorothys_massage_studio
DB_USERNAME=your_database_username
DB_PASSWORD=your_database_password
```

### Optional Environment Variable

```text
PORT=8080
```

## Local Development Setup

### Prerequisites

Make sure the following are installed:

* Java 21
* PostgreSQL
* Git

The Maven Wrapper is included, so Maven does not need to be installed globally.

### 1. Clone the Repository

```bash
git clone https://github.com/ryu11wgu/dorothys-massage-studio-api.git
cd dorothys-massage-studio-api
```

### 2. Create the Local Database

Example using `psql`:

```sql
CREATE DATABASE dorothys_massage_studio;
```

### 3. Set Environment Variables

Example for Linux/macOS:

```bash
export DB_URL=jdbc:postgresql://localhost:5432/dorothys_massage_studio
export DB_USERNAME=your_database_username
export DB_PASSWORD=your_database_password
export PORT=8080
```

Example for PowerShell:

```powershell
$env:DB_URL="jdbc:postgresql://localhost:5432/dorothys_massage_studio"
$env:DB_USERNAME="your_database_username"
$env:DB_PASSWORD="your_database_password"
$env:PORT="8080"
```

### 4. Run the Application

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

By default, the API runs on:

```text
http://localhost:8080
```

### 5. Test the Endpoint

Open the endpoint in a browser or use `curl`:

```bash
curl http://localhost:8080/api/business-info
```

## Seed Data

The application includes startup seed data through `DataSeeder`.

On application startup, the seeder checks whether business information already exists. If the database is empty, it inserts the initial Dorothy's Massage Studio business profile and studio hours.

The seeder currently creates:

* Business name
* Phone display text
* Phone link
* Address lines
* Homepage intro content
* Business hours for Monday through Sunday

If business information already exists, the seeder does not insert duplicate data.

## CORS Configuration

The backend includes CORS configuration for local development and deployed frontend domains.

Allowed frontend origins currently include:

```text
http://localhost:5173
https://www.dorothysmassagestudio.com
https://dorothysmassagestudio.com
https://dorothysmassagestudio-tgqy.vercel.app
```

Allowed methods include:

```text
GET, POST, PUT, DELETE, OPTIONS
```

The current public endpoint only exposes `GET /api/business-info`, but the CORS configuration is prepared for future API expansion.

## Docker

This repository includes a Dockerfile for containerized builds and deployment.

### Build Docker Image

```bash
docker build -t dorothys-massage-studio-api .
```

### Run Docker Container

Example:

```bash
docker run --rm \
  -p 8080:8080 \
  -e DB_URL=jdbc:postgresql://host.docker.internal:5432/dorothys_massage_studio \
  -e DB_USERNAME=your_database_username \
  -e DB_PASSWORD=your_database_password \
  -e PORT=8080 \
  dorothys-massage-studio-api
```

The container starts the Spring Boot application and exposes port `8080`.

## Testing

Run the test suite with:

```bash
./mvnw test
```

The current test suite includes a Spring Boot context load test. Additional unit and integration tests are planned as the API expands.

## Development Highlights

Recent development work includes:

* Created a Spring Boot backend project for the business website
* Configured PostgreSQL database connectivity
* Added environment-based application configuration
* Modeled `BusinessInfo` and `BusinessHour` as JPA entities
* Added a one-to-many relationship between business information and business hours
* Added element collections for ordered address lines and homepage intro paragraphs
* Built repository, service, mapper, DTO, and controller layers
* Added a REST endpoint for business information and studio hours
* Added startup seed data for local and deployed environments
* Configured CORS for the React frontend
* Added Docker support for containerized deployment

## Planned Improvements

Planned improvements include:

* Move services and pricing data into the backend
* Add service offering API endpoints
* Add stronger validation for future write operations
* Add global exception handling
* Add structured logging
* Add health check endpoint
* Add unit and integration tests
* Add API documentation
* Add admin-managed content updates
* Add authentication and protected admin routes
* Add booking or appointment request workflow
* Support future AI assistant integration

## Business Purpose

This API supports Dorothy's Massage Studio by providing a backend foundation for business content and future workflow features. It allows the website to evolve from a static frontend into a maintainable full-stack application with structured data, API-driven content, and room for future administrative tools.

## Maintainer

Developed and maintained by Raymond Yu.
