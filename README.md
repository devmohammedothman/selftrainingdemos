# Spring Boot CRUD H2 DB
This project demonstrates using of below technologies as a proof of concepts by developing restful APIs that can do CRUD operations

#Default USER can Access Read Operations ADMIN Access Write operations
username : user  && password: 123456
username : admin  && password: 123456

#URLS 
http://localhost:8080/angularspringh2jpa/demo/cool-cars
http://localhost:8080/angularspringh2jpa/demo/find-car-by-id/8

http://localhost:8080/angularspringh2jpa/demo/secure/add-car
http://localhost:8080/angularspringh2jpa/demo/secure/update-car
http://localhost:8080/angularspringh2jpa/demo/secure/delete-car

#Embeded Tomcat in Spring  --- simply run 'mvn spring-boot:run'

#Used Technologies:
Spring Boot
Spring Data JPA
Lombok for eliminating boiler plate code 'Note you have to setup it locally'
Model Mapper to map DTOs with Model classes
H2 database as an example of InMemory database and to facilitate runnig the application without real DB schema
