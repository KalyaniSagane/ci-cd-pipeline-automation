# CI/CD Pipeline Automation

An end-to-end CI/CD pipeline that automates the build, test, containerization, and deployment of a Java Spring Boot application using Jenkins, Maven, Docker, and Tomcat.

## Overview

This project demonstrates a complete automated software delivery pipeline — from source code checkout to production-style deployment — reducing manual deployment effort and ensuring consistent, repeatable releases.

## Tech Stack

- **Jenkins** – Pipeline orchestration (Declarative Pipeline / Jenkinsfile)
- **Maven** – Build automation and dependency management
- **Docker** – Application containerization
- **Tomcat** – Application hosting/deployment target
- **Spring Boot** – Sample Java application
- **GitLab CI/CD** – Alternate pipeline configuration (see `.gitlab-ci.yml`)

## Pipeline Stages

1. **Checkout** – Pulls the latest code from the GitHub repository
2. **Build** – Compiles the application and packages it into a JAR using Maven
3. **Test** – Runs automated unit tests to validate the build
4. **Docker Build** – Packages the application into a Docker image
5. **Docker Push** – Pushes the image to a container registry
6. **Deploy** – Deploys the containerized app, exposing it on port 8081

## Results

- Reduced manual deployment steps from ~6 manual actions to a single pipeline trigger
- Automated testing catches build failures before deployment, reducing production issues
- Consistent, containerized deployments eliminate "works on my machine" environment issues

## Project Structure

```
ci-cd-pipeline-automation/
├── src/
│   ├── main/java/com/kalyani/demo/DemoApplication.java
│   └── test/java/com/kalyani/demo/DemoApplicationTests.java
├── Dockerfile
├── Jenkinsfile
├── pom.xml
└── README.md
```

## How to Run Locally

```bash
# Build the application
mvn clean package

# Build the Docker image
docker build -t ci-cd-pipeline-automation .

# Run the container
docker run -d -p 8080:8080 ci-cd-pipeline-automation

# Access the app
curl http://localhost:8080/health
```

## Running the Pipeline in Jenkins

1. Install Jenkins locally or use a Jenkins server
2. Install the Docker and Pipeline plugins
3. Create a new Pipeline job pointing to this repository
4. Jenkins will automatically detect and run the `Jenkinsfile`

## Author

**Kalyani Ghogare**
[LinkedIn](https://linkedin.com/in/kalyani-377a12211) · saganekalyani@gmail.com
