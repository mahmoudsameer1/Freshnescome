Selenium Java Test Automation Framework
Overview
This is a Selenium-based test automation framework written in Java, utilizing TestNG for test management and Allure for reporting.

Features
Automates web testing using Selenium WebDriver.
Organizes tests with TestNG annotations for easy management.
Generates detailed and interactive HTML reports using Allure.

Prerequisites
Java Development Kit (JDK) installed on your system.
Maven installed for project management.
Web browser drivers compatible with Selenium (ChromeDriver, GeckoDriver, etc.).
IDE (IntelliJ IDEA, Eclipse, etc.) for development (optional).

Setup
Clone this repository to your local machine: git clone https://github.com/your-username/your-repository.git
Navigate to the project directory: cd your-repository
Install dependencies using Maven: mvn clean install
Usage
Add your test cases under the src/test/java directory.
Run the tests using Maven: mvn clean test
After the tests have run successfully, generate Allure reports: allure serve target/allure-results This will start a local server and open the Allure report in your default web browser.

Folder Structure
src/main/java: Contains main Java code (if any).
src/test/java: Contains test scripts written in Java.
src/test/resources: Contains test resources such as property files, test data, etc.
target: Contains compiled code, test reports, and other generated files.

Reporting
This project uses Allure for reporting. Allure generates comprehensive HTML reports with detailed information about test executions, including steps, screenshots, and attachments.
