Feature: Scenario Login functionality

  @web @login1
  Scenario: user should be login successfully
    When I enter user name "standard_user" in logIn Screen
    And  I enter password "secret_sauces" in logIn Screen
    And  I click on the login button
    Then Validate that URL contains "invasdasdsdsentoryasdasd" text

  @web @login2
  Scenario: user should be login successfully 2
    When I enter user name "standard_user" in logIn Screen
    And  I enter password "secret_sauce" in logIn Screen
    And  I click on the login button
    Then Validate that URL contains "inventory" text
    And user should be able direct to the home page
    And user choose product with name "Sauce Labs Backpack"