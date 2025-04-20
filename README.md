# Web Automation Project

## Description
This project automates two web forms and scrapes a table from a website using **Selenium WebDriver** and **JUnit**. The main tasks are:
- Automate form submission on [Digital Unite Webform](https://www.digitalunite.com/practice-webform-learners)
- Automate guest registration on [WP Everest Form](https://demo.wpeverest.com/user-registration/guest-registration-form/)
- Scrape stock market data from [DSEBD Website](https://dsebd.org/latest_share_price_scroll_by_value.php)


### Tech Stack

- **Java 17**
- **Selenium WebDriver**
- **JUnit** (for testing)
- **Gradle** (for project management)
- **ChromeDriver** (for browser automation)


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


web-automation-project/ ├── src/ │ └── main/java/ │ ├── automation/ │ │ ├── DigitalUniteForm.java │ │ ├── WpEverestForm.java │ │ └── DsebdScraper.java ├── test-output/ ├── reports/ ├── videos/ ├── screenshots/ ├── README.md ├── build.gradle └── .gitignore


  
