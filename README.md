# jpop-user-service
User Service for JPOP Program

Implementation:
- Uses spring-web, spring-data-jpa and inmemory H2 database
- Uses lombok for generating boiler plate code
- The service context root is /user-api
- Default server port is 8081 
- Added actuator endpoint for health http://localhost:8081/users/actuator/health

Features:
1. Exposes REST APIs for performing basic CRUD operations on User
2. Exposes Swagger UI under the application root context /user-api
3. Swagger api docs are available under /user-api/docs
