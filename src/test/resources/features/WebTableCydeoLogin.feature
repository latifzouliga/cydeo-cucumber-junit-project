
Feature: Login functionality

  Agile story: User should be able to login with correct credentials

  #2- Go to: https://web-table-2.cydeo.com/login
  #3- Enter username: Test
  #4- Enter password: Tester

  Scenario: : Login scenario valid credential
    Given user on login page
    When user enter valid username
    And user enter valid password
    And user click login button
    Then user see url ends with order

  #Try different ways of implementing this step:
  #1- Hard coded implementation

  Scenario: : Login scenario valid credential
    Given user on login page
    When user enter valid username Test
    And user enter valid password Tester
    And user click login button
    Then user see url ends with order


  Scenario: : Login scenario valid credential
    Given user on login page
    When user enter valid credential
      | username | Test   |
      | password | Tester |
    And user click login button
    Then user see url ends with order

  #2- Parameterized implementation (Cucumber expressions)
  #3- Data Tables implementation
  #Note: Follow POM and BDD.
  #OPTIONAL TO USE SCENARIOS AVAILABLE IN THE NEXT PAGE.
  #TRY TO CREATE YOURSELF FOR THE PRACTICE.



  Scenario Outline: : Login scenario invalid credential
    Given user on login page
    When user enter invalid credentials "<username>" "<password>"
    And user click login button
    Then user see error message

    Examples:
      | username      | password      |
      | Test          | wrongPassword |
      | wrongUserName | Tester        |
      | WrongUserName | wrongPassword |
      | Test          | empty         |
      | empty         | Tester        |
















