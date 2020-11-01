Feature: validate API Result Data

  @Regression
  Scenario: validate API Result Data
    Given Get the list of fixed categories items
    And pick one of the categories and verify the query string in the returned JSON