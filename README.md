# Microservices Project Setup Guide

## Prerequisites
- **IntelliJ IDEA** (Ultimate Edition recommended)
- **JDK 17** (Ensure it's properly set up in IntelliJ IDEA)
- **Docker & Docker Compose** (For Zipkin and dependencies)

## Project Structure
```
Microservice-SpringBoot/
├── CloudGateway          # API Gateway
├── ConfigServer          # Centralized Configuration Service
├── OrderService          # Order Management Microservice
├── PaymentService        # Payment Processing Microservice
├── ProductService        # Product Management Microservice
├── service-registry      # Eureka Service Registry
└── README.md             # This guide
```

## Running the Microservices
### Step 1: Open the Project in IntelliJ IDEA
1. Open **IntelliJ IDEA**.
2. Select **File > Open...** and choose the `Microservice-SpringBoot` directory.
3. Wait for the dependencies to resolve.

### Step 2: Run Services in IntelliJ
1. **Start Service Registry**
   - Open `service-registry` module.
   - Locate the main class (e.g., `ServiceRegistryApplication.java`).
   - Click the green ▶️ **Run** button.

2. **Start Config Server**
   - Open `ConfigServer` module.
   - Locate `ConfigServerApplication.java` and **Run** it.

3. **Start Other Microservices** (in any order, but recommended after Config Server is up)
   - `CloudGatewayApplication.java`
   - `OrderServiceApplication.java`
   - `PaymentServiceApplication.java`
   - `ProductServiceApplication.java`

### Step 3: Run Zipkin with Docker
Run the following command in a terminal (make sure Docker is running):
```sh
docker run -d -p 9411:9411 openzipkin/zipkin
```
Zipkin will be available at: [http://localhost:9411](http://localhost:9411)

### Step 4: Test the Microservices
- Use **Postman** or a browser to make requests to the API Gateway.
- Example request:
  ```sh
  curl -X GET http://localhost:9090/order/1
  ```
- View logs in Zipkin to trace requests.

## Troubleshooting
- If a service fails to start, check IntelliJ's **Run** console for errors.
- Ensure Docker is installed and running properly.
- Use `http://localhost:8761` to check the Eureka Service Registry.

Happy coding! 🚀

