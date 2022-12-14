Feature: Register New Class
  Background: Login Admin
    Given User login with valid data
    When Send request post login user
    And Set token to Admin Token

  @Tamara #RegisterNewClass_001
  Scenario: Post create new class using valid data with authorization
    Given Admin create new class with class_name "Bahasa buah"
    When Send request post create new class
    Then Should return status code 201 created
#    And Post create new user json schema validator

  @Tamara #RegisterNewClass_002
  Scenario: Post create new class using valid data without authorization
    Given Admin create new class class_name "Bahasa ayam" without authorization
    When Send request post create new class
    Then Should return status code 400 Bad request
#    And Post create new user json schema validator

  @Tamara #RegisterNewClass_003
  Scenario: Post create new class with empty class name
    Given Post create new class with empty class name
    When Send request post create new class
    Then Should return status code 400 Bad request
#    And Post create new user json schema validator

  @Tamara #RegisterNewClass_004
  Scenario: Post create new class with numeric class name in Body JSON
    Given Admin create new class with class_name 0110110
    When Send request post create new class
    Then Should return status code 400 Bad request
#    And Post create new user json schema validator

  @Tamara #RegisterNewClass_005
  Scenario: Post create new class with special char class name in Body JSON
    Given Admin create new class with class_name "@!$!@"
    When Send request post create new class
    Then Should return status code 400 Bad request
#    And Post create new user json schema validator






