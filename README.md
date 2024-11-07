# URL Shortening Service

## Description

The **URL Shortening Service** is a simple and efficient API that takes a long URL and generates a shorter, more shareable version. This service is useful for reducing long URLs, especially for sharing on social media or other platforms with character limitations. The shortened URLs are stored in a database, allowing seamless redirection from the shortened link to the original URL.

## Features

- **URL Shortening**: Pass a long URL to the service, which returns a shorter version.
- **Database Storage**: Save both the shortened URL and the original long URL in the database for future redirection.
- **HTTP Redirection**: A catch-all route enables seamless redirection from the shortened URL to the original URL.
- **Database Indexing**: For fast retrieval and efficient redirection.

## Technologies Used

- **Backend Framework**: Spring Boot (Java)
- **Database**: MongoDB
- **API Protocol**: REST
- **Tools**: Maven, IntelliJ IDEA

## Endpoints

### 1. Shorten URL

**POST** `/shorten`

**Description**: Accepts a long URL as input and returns a shortened version of it.

### 2. Redirect to Original URL

**GET** `/{shortUrl}`

**Description**: Redirects the user from the shortened URL to the original long URL. This route catches all traffic and performs a database lookup to find the corresponding long URL, then redirects the user to it.

### 3. Error Handling

**If a non-existent or expired shortened URL code is requested, an error response will be returned.**

## Setup and Installation

**1. Clone the Repository**

git clone https://github.com/your-username/url-shortening-service.git

cd url-shortening-service

**2. Install Dependencies**

mvn clean install

**3. Configure Database**

- Set up a database (MongoDB).

- Add your database configuration in the application.properties. In my case `mongodb://localhost:27017/mongodb`

**4. Run the Application**

mvn spring-boot:run

The application will start on `http://localhost:8082`










