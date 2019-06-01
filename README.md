# devchallenge.it-qa-1
Test task for Dev Challenge 13

## Requirements

- Java & JVM (https://www.oracle.com/technetwork/java/javase/downloads/index.html)

- Docker (https://www.docker.com/get-started)

- Allure (https://docs.qameta.io/allure/#_get_started)

## Installation

- Install Java on your PC using instructions for specified platform

- Install Docker on your PC using instructions for specified platform

- Install Allure on your PC using instructions for specified platform

## Running the tests

Using CLI navigate to a directory with a project and run the following command: ```docker run -it -p 8080:8080 vasylenko09/hotels-app```
to start an application

Open new CLI session from same directory and run: ```mvn clean test``` to run the tests

After tests have finished running, run the following command: ```allure serve <path to current dir>/allure-results/``` to view a report
