
Feature: Wikipedia Search Functionality


  Scenario: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box.
    When User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title
  #Note: Follow POM

  Scenario: Wikipedia Search Functionality Header Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box.
    When User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header
  #Note: Follow POM

  Scenario: Wikipedia Search Functionality Image Header Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box.
    When User clicks wiki search button
    Then User sees "Steve Jobs" is in the image header
  #Note: Follow POM


  Scenario Outline: Wikipedia Search Functionality with scenario outline
    Given User is on Wikipedia home page
    When User types "<Search Value>" in the wiki search box.
    When User clicks wiki search button
    Then User sees "<Expected Title>" is in the wiki title
    Then User sees "<Expected Main Header>" is in the main header
    Then User sees "<Expected Image Header>" is in the image header

    @ceos
    Examples: search values we are going to be using in Scenario outline

      | Search Value    | Expected Title  | Expected Main Header | Expected Image Header |
      | Steve Job     | Steve Jobs      | Steve Jobs           | Steve Jobs            |
      | Rosalind Brewer | Rosalind Brewer | Rosalind Brewer      | Rosalind Brewer       |
      | Sundar Pichai   | Sundar Pichai   | Sundar Pichai        | Sundar Pichai         |

    @scientists
    Examples:
      | Search Value    | Expected Title  | Expected Main Header | Expected Image Header |
      | Albert Einstein | Albert Einstein | Albert Einstein      | Albert Einstein       |
      | Marie Curie     | Marie Curie     | Marie Curie          | Marie Curie           |













