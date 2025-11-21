# Eureka Server - Service Discovery

## Overview
Eureka Server acts as a service registry where all microservices register themselves. Other services use Eureka to discover and communicate with each other.

## Configuration
- **Port:** 8761
- **Dashboard:** http://localhost:8761

## Running the Service

### Using Maven Wrapper
```bash
./mvnw spring-boot:run
```

### Using Java
```bash
./mvnw clean package
java -jar target/eureka-server-1.0.0.jar
```

## How It Works
1. Eureka Server starts on port 8761
2. Other microservices register with Eureka on startup
3. Services send heartbeats every 30 seconds
4. Services can discover each other by service name (e.g., "inventory-service")

## Dashboard
Access the Eureka dashboard at: http://localhost:8761

You'll see:
- List of registered services
- Instance status
- Health information

## Dependencies
- Spring Cloud Netflix Eureka Server

## Environment Variables
None required for basic setup.

## Notes
- In standalone mode, Eureka doesn't register with itself
- `register-with-eureka: false` and `fetch-registry: false` are set for standalone operation