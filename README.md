# jpop-user-service
User Service for JPOP Program

## Implementation:
- Uses spring-web, spring-data-jpa and inmemory H2 database. Available at context root /h2-console
- Uses lombok for generating boiler plate code
- The service context root is /user-api
- Default server port is 8081 
- Added actuator endpoint for health http://localhost:8081/users/actuator/health
- Added flyway for easy database/schema migration

## Features:
1. Exposes REST APIs for performing basic CRUD operations on User
2. Exposes Swagger UI under the application root context /user-api
3. Swagger api docs are available under /user-api/docs
4. Uses Cloud Config Server to fetch configurations
5. Uses Eureka Discovery Server to register the instances
