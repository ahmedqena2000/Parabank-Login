Feature: Account Locked After Failed Login Attempts
 Scenario Outline: Verify account is locked after exceeding maximum failed login attempts
    Given the user is on the Login page
   When the user entered invalid "<Username>" and invalid "<Password>"
   And user clicked on login button
   Then the system should display that the account is locked
   Examples:
   | Username | Password|
   |ali_alaa  |12345679 |
   |ali_ala   |123456789|
   |Ali_Ala   |123456789 |

