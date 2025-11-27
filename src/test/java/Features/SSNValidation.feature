Feature: SSN Validation on Forgot Login Info Page

  Scenario: SSN field accepts only numeric input
    Given the user is on the Forgot Login Info page
    When the user enters non-numeric characters into the SSN field
    Then system should display an error message

  Scenario: SSN field requires exactly 9 digits
    Given the user is on the Forgot Login Info page
    When the user enters the SSN less than 9 digits
    Then system should display validation message for short SSN number

  Scenario: SSN field requires exactly 9 digits
    Given the user is on the Forgot Login Info page
    When the user enters the SSN greater than 9 digits
    Then system should display validation message for long SSN number

