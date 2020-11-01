# Audibene API Automation


This is the sample test automation task in which below test scenario is included:

Scenario: validate API Result Data for Fetch Catogy and use it another API for query<br />

● Get the list of fixed categories items.<br />
● pick one of the categories and verify the query string in the returned JSON.<br />

Getting Started
Please follow below instruction to copy the project and running on your local machine for testing purpose

Prerequisites
Maven home: apache-maven-3.5.3

Java version: 1.8.0_201, vendor: Oracle Corporation

Git Bash


#### Running the tests
Given scenario is automated using selenium cucumber. Gherkin language is used in cucumber for these scenario.<br />

Below is the work flow of calling methods in this framework<br />
Feature File >>>> Step Definition File >>>> Main File<br />

For example: Feature file is created for Automation demo in which scenario is written in gherkin language. This feature file calls step definition file through glue code. Then step definition file calls main page file in which all methods are defined.<br />

Installation<br />
Linux Machine<br />
If you’re on Fedora for example (or any closely-related RPM-based distro such as RHEL or CentOS), you can use below command to install Git:<br />

$ sudo dnf install git-all<br />
If you’re on a Debian-based distribution like Ubuntu, try apt-get:<br />

$ sudo apt-get install git-all<br />
Install Maven<br />

$ sudo apt-get install maven<br />
Clone the project from below location:<br />
git@github.com:teenagauttam/audibeneAPI.git <br />

Go to source folder in local machine<br />
audibeneAPI<br />

Run " mvn test " command in source folder " audibenAPI " from your maven or git bash mvn test

## Check Report

1. After running the test, Target folder will be generated in root folder and extent.html file will be generated in target folder.

2. Click on extent.html to see the report of the execution.