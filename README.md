# Demo Banking microservices with Spring Boot and Spring Cloud

This repository contains a microservices-based banking application, developed using Spring Boot and Spring Cloud. 
The project consists of several services including account-service, config-service, customer-service, and more, managed and orchestrated through Docker Compose.

## Services
  Account Service: Manages bank accounts, transactions, and balances.
  Config Service: Centralized configuration service for all microservices.
  Config Repository: Stores the configuration properties for the services.
  Customer Service: Handles customer-related information and operations.
  Discovery Service: Eureka server for service discovery.
  Gateway Service: API Gateway to route external requests to internal microservices.
  
## Project Structure
  account-service/: Service responsible for account management.
  config-service/: Centralized service for external configuration.
  config-repository/: Contains configurations for services.
  customer-service/: Handles customer operations.
  discovery-service/: Eureka discovery server for registering and discovering services.
  gateway-service/: API Gateway to route requests to the appropriate services.
  docker-compose.yml: Docker Compose file to orchestrate all services.
  
## Technologies Used
  Spring Boot
  Spring Cloud (Eureka, Gateway, Config Server)
  Spring Security with JWT
  PostgreSQL for data storage
  Docker for containerization
  Hibernate for ORM
  Maven for project build
## Getting Started
  Prerequisites
  Java 17 or later
  Maven 3.8.x
  Docker and Docker Compose
  PostgreSQL database
