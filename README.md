# ABC Rentals – Java Domain-Driven Backend

This project was completed as part of a **4-hour practical examination** for **University**. The goal was to implement a **Domain-Driven Design (DDD) back-end application** for a property rental company expanding to an online platform.

The system was developed using **Java, JPA (Hibernate), Maven, and MySQL**, based on a provided UML domain model. The focus was on backend architecture, validation, and test coverage rather than UI design.

## Features
- Domain modeling with **inheritance and composition** (Property, House, Apartment, RentalAgent)
- **Builder Pattern** for all entities (no Lombok)
- Validation of mandatory attributes with safe object creation
- **JPA repositories** for database persistence
- **Service layer** implementing business logic
- **RESTful controller** (HouseController implemented)
- **JUnit 5 tests** for factories, services, and controllers
- Clear separation of **domain, factory, repository, service, and controller** layers
- MySQL and Maven configuration for easy setup

## Technologies
- Java 21
- Maven
- JPA / Hibernate
- MySQL
- JUnit 5
- Postman (for testing REST endpoints)
- IntelliJ IDEA Ultimate
