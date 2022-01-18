FROM openjdk:8 as build
ADD target/CA-EmployeeManagement.jar ca-employeemanagement.jar
EXPOSE 9191
ENTRYPOINT ["java", "-jar", "/ca-employeemanagement.jar"]