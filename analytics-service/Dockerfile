# Stage 1: Build stage
FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Secure Runtime stage
FROM eclipse-temurin:21-jre-alpine AS runner
WORKDIR /app

# Create a non-root group and user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copy JAR from builder and set ownership to appuser
COPY --from=builder --chown=appuser:appgroup /app/target/analytics-service-0.0.1-SNAPSHOT.jar app.jar

# Set environment variables for Spring Boot management endpoints
ENV MANAGEMENT_ENDPOINTS_WEB_EXPOSURE_INCLUDE=health
ENV MANAGEMENT_ENDPOINT_HEALTH_SHOW_DETAILS=never

# Switch to non-root user
USER appuser

EXPOSE 4002

ENTRYPOINT ["java", "-jar", "app.jar"]