# Pricing API

## Overview
My solution implements a technical solution with Hexagonal Architecture with DDD and SOLID principles.
To ensure the separation of responsibilities and improve the maintenance of the code.

## How run
Requirements:
- Java: 21
- maven: 3.9.9

You can run with the command `mvn spring-boot:run`
You can run the unit and persistence tests and karate tests with the command `mvn verify`

## Architecture Overview

### Hexagonal Architecture + DDD
The system is divided into clear layers:
- **Domain Layer** – The layer that contains our business rules. In this layer I added the entities, Value Objects, domain services and repository interface.
- **Application Layer** – The layer that contains all the use cases that coordinate our domain logic.
- **Infrastructure Layer** – The layer that connect our application with the outside. This includes user interface (REST), config, and adapters (e.g., repository).

This structure ensures the domain logic free of external systems or frameworks promoting flexibility and maintainability.

## Tools
I used H2 database and liquibase for the migrations of the database.

## Testing
I created all the unit tests to ensure the coverage of all the code.
I created an integration test for the database.
I added karate test for the acceptance tests.
