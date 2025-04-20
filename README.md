# Web Automation Project

## Description
This project automates two web forms and scrapes a table from a website using **Selenium WebDriver** and **JUnit**. The main tasks are:
1. Automating the submission of a web form.
2. Automating the user registration form.
3. Scraping data from a table on a webpage and storing it in a text file.


## Technologies Used

- **Selenium WebDriver**
- **JUnit 5**
- **Java 17**


## Prerequisites

Before running the tests, ensure the following tools are installed:

- Java 17 or higher
- Selenium WebDriver
- JUnit 5 for testing
- ChromeDriver (or any other driver, depending on the browser you're using)

Dependencies required for the project are already included in the `build.gradle` file, which you can find in the project directory. The relevant dependencies are:

```groovy
dependencies {
    testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    implementation 'org.seleniumhq.selenium:selenium-java:4.31.0'
}





  
