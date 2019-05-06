Feature: Test with method get

  Scenario: Verify if has username,name and email
    Given I want to see user 1
    When I call the api get with the ID of the user
    Then the Api return the information
    And we verify if has name, username and email

  Scenario: Verify if email is valid
    Given I want to see user 1
    When I call the api get with the ID of the user
    Then the Api return the information
    And we verify the email if is valid

  Scenario: Verify if catchphrase must have less than 50 characters
    Given I want to see user 1
    When I call the api get with the ID of the user
    Then the Api return the information
    And we verify if catchphrase must have less than 50 characters
