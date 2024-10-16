# Toy Manager

A very basic Spring Boot example project for REST service.

## This project has:
- Spring Boot Web and test dependencies using Maven
- REST service using `RestController`
  - HTTP GET Service to return all Toy names
- Java OOB
- Use of Java Enum with parameters
- Use of Java `Cloneable` with Deep Copy and collection return
- Use of Aspect Oriented Programming for storage upkeep
- Use of Stream and map
- Builder pattern to create Toy objects, selectively set properties
#
- JUnit Jupiter 5 unit tests for beans and Service
- Junit Jupiter 5 MockMvc tests for REST service
#
- Open API 3.0 documentation of REST Services - openapi toy manager.yaml
- If the application is running, Postman can send a request to get back a list of strings: `http://localhost:8080/toys/available`
