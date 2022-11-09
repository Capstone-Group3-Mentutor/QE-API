Feature: Delete User Account
  Background: Login Admin
    Given User login with all valid data
    When Send request post login user
    Then Should return 200 OK
    And Set token to Admin Token

  @Tamara
  Scenario Outline: Delete User Account with Valid Id
    Given Delete class with valid id <id>
    When Send request delete a class
    Then Should return 200 OK
    And Response body should contain message "Success Delete Class"
    Examples:
      | id |
      | 9 |
      | 10 |

  @Tamara
  Scenario Outline: Delete Exiting Class without Authorized
    Given Delete class valid id <id> without authorized
    When Send request delete a class
    Then Should return 400 Bad request
    And Response body should contain message "Invalid Input from Client"
    Examples:
      | id |
      | 9 |
      | 10 |

  @Tamara
  Scenario Outline: Delete Exiting Class With Unregistered Id
    Given Delete class unregistered Id <id>
    When Send request delete a class
    Then Should return 404 Not Found
    And Response body should contain message "Not Found"
    Examples:
      | id |
      | 200 |
      | 300 |

  @Tamara
  Scenario Outline: Delete Exiting Class With Invalid Id
    Given Delete class unregistered Id "<id>"
    When Send request delete a class
    Then Should return 404 Not Found
    And Response body should contain message "Not Found"
    Examples:
      | id |
      | twelve |
      | @*@!*@ |

  @Tamara
  Scenario Outline: Delete Exiting Class With Id has been deleted
    Given Delete class with Id <id> has been deleted
    When Send request delete a class
    Then Should return 404 Not Found
    And Response body should contain message "Not Found"
    Examples:
      | id |
      | 22 |
      | 21 |
