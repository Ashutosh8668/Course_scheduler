**Course Assigning Application**
This repository contains a Java Spring Boot application designed to manage and assign courses to college faculty members.

**Course Assigning Application**

This repository contains a Java Spring Boot application designed to manage and assign courses to college faculty members.


## Overview
The Course Assigning Application is a tool for college administrators to manage course assignments efficiently. It allows users to assign courses to faculty members, view details about the assigned courses, and manage course-related data.

## Features
- Assign courses to faculty members
- View detailed information about assigned courses
- Manage faculty and course data
- Dockerized setup for easy deployment

## Technologies Used
- Java Spring Boot
- MySQL
- Docker & Docker Compose

## Getting Started

### Prerequisites
- Java 17 or higher
- Docker and Docker Compose installed on your machine
- Maven for building the project

## Docker Setup

### Building and Running the Application
1. Build and run the Docker containers using Docker Compose:
   --------------------------
   docker-compose up --build
   --------------------------
   
2. The application will be available at `http://localhost:8080`.

### Stopping the Application
To stop the application, run:
--------------------
docker-compose down
--------------------

## Usage
- Access the application at `http://localhost:8080`.
- Assign courses to faculty through the provided UI.
- Manage and view detailed information about faculty and courses.

