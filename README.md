# Springboot Coding Challenge

Basic implementation of a springboot WS using Spring Data REST

### Prerequisites

Java 1.8, Gradle 4.10.2

### Installing

```
chmod +x gradlew
./gradlew build
```

### Running

````
java -jar build/libs/codingchallenge-0.0.1-SNAPSHOT.jar
````

## Testing the Endpoints

Server will start on http://localhost:8080

Login with: test:test

Accounts owned by customer #1
http://localhost:8080/accounts/search/findByPrimaryOwnerId?primaryOwnerId=1

Transactions originating from account #2
http://localhost:8080/transactions/search/findBySourceAccountId?sourceAccountId=2

## Running Tests

````
./gradlew test
````

## TODO

A great deal of things not possible in the 3.5 hours :-D 

* Security Roles / Assigned permissions
* Logging
* Better way of loading data for testing of API
* Tests for the API

## Notes

Excuse the mess, haven't done any Spring Boot in 2.5 years. Would have prefered GoLang :-D