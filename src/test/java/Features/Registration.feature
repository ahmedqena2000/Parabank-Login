Feature: User Registration


  Scenario: Verify successful registration with valid data
    Given the user is on the Registration page
    When the user enters valid registration details
    And click the Register button
    Then the account should be created successfully


    Scenario: Verify registration when all fields are empty
      Given the user is on the Registration page
      When the user submits the registration form without entering any data
      Then validation messages should be displayed for all mandatory fields


      Scenario: Register with duplicate usernames
        Given the user already exists with username
        And the user is logged out
        When user register with same username
        And clicked the Register button
        Then an error message should be displayed the username already exists
