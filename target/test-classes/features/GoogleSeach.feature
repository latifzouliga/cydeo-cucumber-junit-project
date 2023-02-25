
@google
Feature: Google search function

  Scenario: As a user I want to search for a product and get relevant result
    Given user on google search page
    When user enter clothes in google search box
    Then usr see title clothes - Google Search


