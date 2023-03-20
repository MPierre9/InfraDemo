FROM amd64/openjdk:17-slim

COPY target/infra-web-app.jar /app/infra-web-app.jar

EXPOSE 8080

# Set the command to run JAR file
CMD ["java", "-jar", "/app/infra-web-app.jar"]
