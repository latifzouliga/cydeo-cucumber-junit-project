
@etsy
Feature: Etsy search functionality
  Agile Story: User should be able to type any keyword and see relevant information


  Scenario: Etsy title verification
    Given user is on the Etsy homepage
    Then user should see title as expected


  Scenario: Etsy Search Functionality Title Verification (without parameterization)
    Given user is on the Etsy homepage
    When User types Wooden Spoon in the search box
    And User clicks search button
    Then User sees Wooden Spoon is in the title


  Scenario: Etsy Search Functionality Title Verification (with parameterization)
    Given user is on the Etsy homepage
    When User types "Wooden Spoon" in the search box
    And User clicks search button
    Then User sees Wooden Spoon is in the title
