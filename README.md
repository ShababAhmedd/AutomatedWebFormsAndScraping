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

Before running the tests, ensure the following:

- Java 17 or higher
- ChromeDriver (or another WebDriver if you're using a different browser)

The project dependencies for Selenium WebDriver and JUnit 5 are already configured in the `build.gradle` file:

```groovy
dependencies {
    testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    implementation 'org.seleniumhq.selenium:selenium-java:4.31.0'
}
```





  
