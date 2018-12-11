#Php Travels Flight Reservation - Java
Automate the reservation process of a flight using https://www.phptravels.net which is a site for practicing QA automation over travel reservations. The reservation process includes searching a flight using the search box, selecting a flight from the list and complete the reservation flow.

## Getting Started
1. Open a terminal window/command prompt
2. Clone this project.
3. Run ``` mvn clean verify``` in the top level directory of the project 
4. All dependencies should now be downloaded and the test will have run successfully.

### Prerequisites
1. Java JDK v1.8
2. Maven: to have the command-line tool running: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
3. Chrome (latest version)

## Running the tests
Run 'mvn clean test' will run the test successfully.
```
mvn clean test
```
There is only on test, **ReserveFlightTest** that will automate the reservation process of a flight, from searching the flight, to choosing the cheapest flight displayed, entering the user data and confirming the reservation. 
In the folder **./logs** there will be a log file with the date stamp for each run and also a screenshot in case the test failed. Log file will include output details from the test, steps, data used, results, assertions, fails and screenshot name in case of created.

## Test Driven Data approach
It is easy to create a new scenario just changing data. In the file **TestDrivenData.csv** can be found:

1. Environment configuration: url to the test site.
2. Runner configuration: time out in seconds to wait for elements with WebDriver, by default 20 seconds.
3. Test data - Flight: city from, city to and date. In the search for the city the test will pick up the top result of the dropdown box, therefore if the city to search has a exactly match, that will be the only result and the one to use.
4. Test data - User details: name, last name, email mobile, address and country.

### And test coding style tests
1. WebElements are being asserted (and waited for) in each page, when landing and when interacting with them. 
2. Test data asserted, part of the test data is asserted (as name, last name, address, etc...) in invoice page, to confirm that it is the same one used in the whole process. 
3. Test data validated, other test data is just validated (it will not stop the test), as cities, logged as a warning, because the name could vary from the pick list to the invoice page.
4. Other data not asserted or validated, as date or price for the ticket, as the page is not reliable for this details.
 
## Built With
*  Page Object Model (POM) & Page Factory in Selenium.
* [Maven](https://maven.apache.org/) - Dependency Management 

### Code re-use
The framework has been created to make it easier to re-use the code (hooks, drivers, logs, test data, screenshots...) and add more tests, modules, pages objects, etc...

## Improvements
Improvements to be done with more time:
* Adding multiple browsers.
* Choosing return flight.
* Pay with credit card or other payment method.
* Sign in as a user into php travels.
* Having different files for test user data, environment configuration, runner, etc.
* Create specific objects to manage the user's data or the reservation as an object with multiple fields. 
*
