##Task 2: Bing Search Title Verification
#   #1. Go to https://www.google.com
#   #2. Search for "orange"
#   #3. Verify title is:
#   #a. Expected = "orange - Search"
#   #Note
#   #1. Follow POM Design Pattern
#   #2. BDD implementation

Feature:  Bing search functionality
  Agile story: As a user, when I am on the Bing search page I should be able to search
  anything and see relevant results

  Scenario: As a user I want to search for product and get relevant result
    Given user on Bing search page
    When user enter "orange" in bing search box
    Then user should see title is "orange - Search"


  Scenario: As a user I want to search for product and see kiwi
    Given user on Bing search page
    When user enter kiwi in bing search box
    Then user should see title is "kiwi - Search"