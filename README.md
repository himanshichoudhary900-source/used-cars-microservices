# Used Cars Microservices Platform

A comprehensive microservices-based platform for managing used car sales and service bookings, built with Spring Boot and Spring Cloud.


## Project Background

This microservices platform was originally developed during a hackathon with my team. After the hackathon, I took ownership of enhancing and productionizing the application.

**Post-Hackathon Individual Enhancements:**

After the hackathon, I continued developing the platform with the following improvements:

✅ **Technical Improvements:**
- Resolved Java compatibility issues across all services
- Enhanced error handling and validation
- Improved security implementations
- Optimized database configurations
- Cleaned and refactored codebase

✅ **DevOps (In Progress):**
- Docker containerization for all microservices
- docker-compose for orchestration
- Production-ready deployment setup

✅ **Documentation:**
- Comprehensive README with setup instructions
- API documentation
- Code cleanup and best practices

## Architecture

This project demonstrates a complete microservices architecture with:
- **Service Discovery** - Eureka Server for dynamic service registration
- **Multiple Domain Services** - Inventory, User, Booking services
- **Frontend Service** - Server-side rendered web application
- **Independent Scalability** - Each service can scale independently

### System Architecture
```
┌─────────────────────────────────────────────────┐
│          Microservices Architecture             │
├─────────────────────────────────────────────────┤
│                                                  │
│  ┌──────────────┐                               │
│  │ Eureka Server│ ←─────── Service Registry     │
│  │   (8761)     │          & Discovery          │
│  └──────┬───────┘                               │
│         │                                        │
│         ├─────────────┬──────────────┐          │
│         ↓             ↓              ↓          │
│  ┌─────────────┐ ┌──────────┐ ┌──────────┐    │
│  │ Inventory   │ │   User   │ │ Booking  │    │
│  │  Service    │ │ Service  │ │ Service  │    │
│  │             │ │  (8081)  │ │  (8084)  │    │
│  └──────┬──────┘ └────┬─────┘ └────┬─────┘    │
│         │             │             │           │
│         └─────────────┴─────────────┘           │
│                       ↑                          │
│              ┌────────┴────────┐                │
│              │   Web App       │                │
│              │   Service       │                │
│              │    (8080)       │                │
│              └─────────────────┘                │
│                       ↑                          │
└───────────────────────┼──────────────────────────┘
                        │
                   User Browser
```

## Services

### 1. Eureka Server (Port 8761)
**Service Discovery and Registration**
- Central registry for all microservices
- Health monitoring and load balancing
- Dynamic service discovery

**Key Features:**
- Automatic service registration
- Heartbeat-based health checks
- Service instance tracking

---

### 2. Inventory Service
**Car Inventory Management**
- Complete CRUD operations for car listings
- Search and filter capabilities
- Status management (Available, Sold)

**Key Features:**
- RESTful API with validation
- Global exception handling
- MySQL database integration
- DTO pattern for clean separation

**Tech Stack:** Spring Boot, Spring Data JPA, MySQL, Lombok, ModelMapper

---

### 3. User Service (Port 8081)
**Authentication & User Management**
- User registration and login
- JWT-based authentication
- Role-based access control

**Key Features:**
- BCrypt password encryption
- JWT token generation and validation
- Spring Security integration
- Role management (ADMIN, CUSTOMER)

**Tech Stack:** Spring Boot, Spring Security, JWT, MySQL, BCrypt

---

### 4. Service Booking Service (Port 8084)
**Car Service Appointment Management**
- Schedule service appointments
- Booking status tracking
- Customer information management

**Key Features:**
- CRUD operations for bookings
- Status workflow (Pending, Confirmed, Completed, Cancelled)
- Date and time management

**Tech Stack:** Spring Boot, Spring Data JPA, MySQL, Lombok

---

### 5. Web App Service (Port 8080)
**Frontend User Interface**
- Server-side rendered pages
- Responsive design
- Integration with all backend services

**Key Features:**
- Thymeleaf template engine
- Bootstrap UI components
- WebClient for service communication
- Mock data for development

**Tech Stack:** Spring Boot, Thymeleaf, Bootstrap 5, WebFlux

## Technology Stack

### Backend
- **Java 17** - Programming language
- **Spring Boot 3.3.3** - Application framework
- **Spring Cloud 2023.0.3** - Microservices framework
- **Spring Data JPA** - Data persistence
- **Spring Security** - Authentication & authorization
- **MySQL** - Relational database
- **Lombok** - Boilerplate reduction
- **ModelMapper** - Object mapping

### Frontend
- **Thymeleaf** - Template engine
- **Bootstrap 5** - CSS framework
- **JavaScript** - Client-side scripting

### DevOps
- **Maven** - Build tool
- **Docker** (In Progress) - Containerization
- **Docker Compose** (In Progress) - Multi-container orchestration
- **Git** - Version control

### Tools & Libraries
- **JWT (jjwt 0.11.5)** - JSON Web Tokens
- **BCrypt** - Password hashing
- **Eureka Client/Server** - Service discovery
- **Zipkin** - Distributed tracing
- **Actuator** - Application monitoring

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**
- **MySQL 8.0+**
- **Git**
- **Docker & Docker Compose** (for containerized deployment - coming soon)

## Project Structure
```
used-cars-microservices/
├── eureka-server/              # Service discovery server
│   ├── src/
│   └── pom.xml
├── inventory-service/          # Car inventory management
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── usedcarsproject/inventoryservice/
│   │       │       ├── controller/
│   │       │       ├── service/
│   │       │       ├── repository/
│   │       │       ├── entity/
│   │       │       ├── dto/
│   │       │       └── advice/
│   │       └── resources/
│   └── pom.xml
├── user-service/               # Authentication & user management
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/usedcars/user/
│   │       │       ├── controller/
│   │       │       ├── service/
│   │       │       ├── repository/
│   │       │       ├── model/
│   │       │       ├── dto/
│   │       │       └── security/
│   │       └── resources/
│   └── pom.xml
├── service-booking-service/    # Service appointment bookings
│   ├── src/
│   └── pom.xml
├── web-app-service/           # Frontend application
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       ├── resources/
│   │       │   └── templates/
│   │       │       ├── cars/
│   │       │       ├── user/
│   │       │       ├── service/
│   │       │       └── fragments/
│   └── pom.xml
├── pom.xml                    # Parent POM
├── .gitignore
└── README.md
```

## Running Locally

### 1. Clone the Repository
```bash
git clone https://github.com/himanshichoudhary900-source/used-cars-microservices.git
cd used-cars-microservices
```

### 2. Setup MySQL Database

Create databases for each service:
```sql
CREATE DATABASE inventory_db;
CREATE DATABASE usedcarsdb;
CREATE DATABASE service_booking_db;
```

### 3. Configure Database Credentials

Update `application.properties` or `application.yml` in each service with your MySQL credentials:
```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

### 4. Build All Services
```bash
# From root directory
mvn clean install
```

### 5. Start Services (In Order)

**Terminal 1 - Eureka Server:**
```bash
cd eureka-server
mvn spring-boot:run
```

Wait for Eureka to start (check http://localhost:8761)

**Terminal 2 - Inventory Service:**
```bash
cd inventory-service
mvn spring-boot:run
```

**Terminal 3 - User Service:**
```bash
cd user-service
mvn spring-boot:run
```

**Terminal 4 - Booking Service:**
```bash
cd service-booking-service
mvn spring-boot:run
```

**Terminal 5 - Web App:**
```bash
cd web-app-service
mvn spring-boot:run
```

### 6. Access the Application

- **Eureka Dashboard:** http://localhost:8761
- **Web Application:** http://localhost:8080
- **API Endpoints:** See API Documentation below

## API Documentation

### Inventory Service API

**Base URL:** `http://localhost:<random-port>/api/cars`

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| GET | `/api/cars` | Get all available cars | - |
| GET | `/api/cars/{id}` | Get car by ID | - |
| POST | `/api/cars` | Add new car | CarDto |
| PUT | `/api/cars/{id}` | Update car | CarDto |
| DELETE | `/api/cars/{id}` | Delete car | - |

**CarDto Example:**
```json
{
  "brand": "Toyota",
  "model": "Camry",
  "year": 2020,
  "mileage": 25000,
  "price": 22000.00,
  "color": "Silver",
  "transmission": "Automatic",
  "fuelType": "Petrol",
  "carStatus": "AVAILABLE",
  "description": "Well maintained sedan",
  "dateListed": "2024-01-15"
}
```

---

### User Service API

**Base URL:** `http://localhost:8081/api/users`

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/api/users/register` | Register new user | UserDto |
| POST | `/api/users/login` | User login | Credentials |
| GET | `/api/users` | Get all users | - |
| GET | `/api/users/{id}` | Get user by ID | - |
| DELETE | `/api/users/{id}` | Delete user | - |



### Booking Service API

**Base URL:** `http://localhost:8084/api/bookings`

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| GET | `/api/bookings` | Get all bookings | - |
| GET | `/api/bookings/{id}` | Get booking by ID | - |
| POST | `/api/bookings` | Create new booking | BookingDto |
| PUT | `/api/bookings/{id}/status` | Update status | Status |
| DELETE | `/api/bookings/{id}` | Cancel booking | - |

## Features

### ✅ Implemented

- **Microservices Architecture** - Independent, scalable services
- **Service Discovery** - Automatic registration with Eureka
- **RESTful APIs** - Clean API design with proper HTTP methods
- **Data Validation** - Input validation with Bean Validation
- **Exception Handling** - Global exception handling with custom responses
- **Security** - JWT authentication, BCrypt password hashing
- **Database Integration** - MySQL with JPA/Hibernate
- **DTO Pattern** - Clean separation between layers
- **Responsive UI** - Bootstrap-based frontend
- **Load Balancing** - Client-side load balancing via Eureka
- **Distributed Tracing** - Zipkin integration (optional)

### 🔄 In Progress

- **Docker Containerization** - Dockerfiles for all services
- **Docker Compose** - Multi-container orchestration
- **Production Deployment** - Environment-specific configurations

### 📋 Planned Enhancements

- [ ] API Gateway - Centralized routing and filtering
- [ ] Centralized Configuration - Spring Cloud Config Server
- [ ] Message Queue - Kafka/RabbitMQ for async communication
- [ ] Caching Layer - Redis integration
- [ ] Search Functionality - Elasticsearch integration
- [ ] CI/CD Pipeline - GitHub Actions/Jenkins
- [ ] Monitoring - Prometheus & Grafana
- [ ] Kubernetes Deployment - K8s manifests

## Current Status

⚠️ **Development in Progress**

**Working:**
-  Complete microservices architecture
-  Service discovery with Eureka
-  All business logic implemented
-  RESTful API endpoints

**In Progress:**
-  Docker containerization
-  Production environment setup
-  Resolving local environment compatibility issues

**Note:** The application is being enhanced with Docker deployment to ensure consistent execution across different environments.

## Development Setup

### Running in Development Mode

For development, each service can be run independently:
```bash
# Run with dev profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Hot Reload

Spring Boot DevTools is configured for hot reload during development.

### Debug Mode
```bash
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
```

## Testing
```bash
# Run all tests
mvn test

# Run tests for specific service
cd inventory-service
mvn test
```

## Troubleshooting

### Common Issues

**Issue: Services can't connect to Eureka**
- Ensure Eureka Server is running on port 8761
- Check `eureka.client.service-url.defaultZone` in application.yml

**Issue: Database connection failed**
- Verify MySQL is running
- Check database credentials in application.properties
- Ensure databases are created

**Issue: Port already in use**
- Check which process is using the port: `netstat -ano | findstr :PORT`
- Kill the process or use a different port

## License

This project is open source and available under the MIT License.

## Contact

**Himanshi Choudhary**
- GitHub: [@himanshichoudhary900-source](https://github.com/himanshichoudhary900-source)
- Email: [himanshichoudhary900@gmail.com]

## Acknowledgments

- Original hackathon team members for collaboration
- Spring Boot and Spring Cloud communities
- Open source contributors

---

*This project was developed as part of learning microservices architecture and Spring Cloud ecosystem, with continuous enhancements for production readiness.*
