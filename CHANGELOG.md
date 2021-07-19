# jpop-user-service

## 19-JULY-2021

### Implementation

    - Updated the return type from Object to specific type
    - Changed from HttpStatus.GONE to ACCEPTED
    - Updated the sequence generation strategy for primary key column
    - Fixes and improvements

### Configuration

    - Updated the hibernate.ddl-auto property to update

## 22-JUNE-2021

### Configuration

    - Added spring cloud dependencies for eureka, cloud config
    - Added spring-cloud-starter-bootstrap for using legacy cloud config connection using bootstrap.yml

## 20-JUNE-2021

### Configuration

    - Added h2 inmemory and persistent store switch
    - Added flyway for easy data migration

## 19-JUNE-2021

### Documentation

    - Added Swagger 3 - Open API 3.0
    - Configured swagger properties

## 13-JUNE-2021

### Documentation

    - Added CHANGELOG.md

### Implementation

    - Added User DTO
    - Added DTO to Entity mapper
    - Changed the root context path to /user-api
    - Excluded stack trace errors in response
    - Added interface for controller to segregate business logic and configurations
    - Added generic response for user api
    - Added exception handlers
    - Added mapstruct for class mapping

## 09-JUNE-2021

### Documentation

    - Added README.md

### Implementation

    - Created basic CRUD api for user