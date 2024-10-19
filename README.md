# Spring Cloud Microservices With Eureka



## Overview

This project demonstrates a **microservices architecture** that involves three key microservices:

1. **Product Service**
2. **Review Service**
3. **Recommendation Service**

Additionally, a **Product Composite Service** aggregates data from the other three microservices and provides a unified response.

Each microservice handles a specific aspect of the system:

- **Product Service**: Manages product details, including attributes such as product name, weight, and other related information.
- **Review Service**: Manages customer reviews for products, storing details such as the review's author, content, subject, and associated product.
- **Recommendation Service**: Manages product recommendations, providing ratings, author details, and recommendation content.

The **Product Composite Service** fetches and aggregates information from these three microservices, providing a consolidated view of:
- Product information (from the Product Service)
- A list of reviews for the product (from the Review Service)
- A list of recommendations for the product (from the Recommendation Service)

## Technologies Used

- **Spring Boot** for building microservices.
- **OpenFeign** for microservice communication.
- **Load Balancers** for managing requests between services.
- **MySQL** for database management of each service’s data.
- **Docker** for containerization and deployment.
- **Tomcat** as the embedded web server.
- **Eureka** (optional) for service discovery (to be added in future enhancements).

## Microservice Details

### 1. Product Service

Handles product-related data such as:
- **Product ID**: Unique identifier for the product.
- **Product Name**: The name of the product.
- **Weight**: The weight of the product.
- **Recommendation ID and Review ID**: Links to corresponding recommendations and reviews.

### 2. Review Service

Stores and manages product reviews with attributes like:
- **Review ID**: Unique identifier for each review.
- **Author**: The name of the reviewer.
- **Content**: The content of the review.
- **Subject**: The review's subject.

### 3. Recommendation Service

Handles product recommendations with the following attributes:
- **Recommendation ID**: Unique identifier for each recommendation.
- **Rating**: The rating given to the product.
- **Author**: The person recommending the product.
- **Content**: The recommendation text.

### 4. Product Composite Service

Acts as a composite service that:
- Aggregates product data, reviews, and recommendations.
- Provides a unified response that includes all necessary information for a given product.

## Local Setup and Configuration

Since there is no service discovery mechanism implemented, the microservices will run locally with hard-coded ports for communication. The ports used for each service are:
- **Product Service**: `localhost:7001`
- **Review Service**: `localhost:7002`
- **Recommendation Service**: `localhost:7003`
- **Product Composite Service**: `localhost:7000`

### Steps to Run the Project Locally

1. Clone the repository.
   ```bash
   git clone <repository-url>
2. Set up the MySQL database for each service and update the application properties with your database configuration:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/productservice
   spring.datasource.username=root
   spring.datasource.password=yourpassword

3. Run each microservice individually using:

   ```bash 
   mvn spring-boot:run
4. Access the APIs through the following endpoints:

- Product Service: http://localhost:7001/api/products/{productId}
- Review Service: http://localhost:7002/api/reviews/{reviewId}
- Recommendation Service: http://localhost:7003/api/recommendations/{recommendationId}
- Product Composite Service: http://localhost:7000/api/products/{productId}
5.Set Up `Eureka`

**Eureka** is a service discovery tool for microservices. It allows services to register themselves at runtime as they come up, and to discover other services to call them. Here’s how to set up Eureka in your Spring Boot application.

- Add Dependencies

In your `pom.xml` (if you are using Maven), add the following dependencies:

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
Make sure to also include the Spring Cloud dependencies in your pom.xml:
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Hoxton.SR12</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
- Add Annotations to Server Application class.
```java
@EnableEurekaServer

### Future Enhancements

- Circuit Breaker: Add Hystrix or Resilience4j for better fault tolerance.
- Docker Compose: Add a Docker Compose file to easily set up and manage all microservices together.
