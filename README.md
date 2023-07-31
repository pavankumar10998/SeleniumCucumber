# SeleniumCucumber Project

This project demonstrates automation testing using Selenium and Cucumber with Java. It includes features for filter search and product search on eBay.

## Prerequisites

- Java Development Kit (JDK) installed
- Maven installed
- Chrome browser installed

## Setup

1. Clone the repository or download the project files.

2. Open the project in your preferred IDE.

3. Install the required dependencies specified in the `pom.xml` file using Maven.

## Running the Tests

To run the tests, follow these steps:

1. Open the `TestRunner` class located in the `testRunner` package.

2. Right-click on the class and select "Run" or "Run as JUnit test" to execute the Cucumber tests.

3. The tests will run, and the results will be displayed in the console.

## Project Structure

The project has the following structure:

- `src/test/resources/features`: Contains the feature files written in Gherkin syntax.
    - `FilterSearch.feature`: Feature file for applying filters.
    - `ProductSearch.feature`: Feature file for product search.

- `src/test/java/stepDefinitions`: Contains the step definition files.
    - `EbaySearch.java`: Step definitions for the eBay search functionality.

- `src/test/java/testRunner`: Contains the test runner class.
    - `TestRunner.java`: Cucumber test runner class to execute the feature files.

- `pom.xml`: Maven configuration file specifying the project dependencies.

## Additional Notes

- The `chromedriver` executable is assumed to be located at the following path: `/Users/rpkumar/eclipse-workspace/SeleniumPractice/chromedriver`. Update this path in the `EbaySearch` class if necessary.

- You can customize the tests by modifying the feature files and the corresponding step definition methods in the `EbaySearch` class.

- Test results will be displayed in the console, indicating the success or failure of each test scenario.

