
@dropdown
Feature: Cucumber Data Tables implementation practice



  Scenario: List of fruits and vegetables I like
    Then user should see bellow list
      | orange     |
      | apple      |
      | kiwi       |
      | strawberry |
      | tomato     |
      | peer       |
      | eggplant   |

    # Create a new scenario where we list the colors we are gonna use

  Scenario: List of colors that I will use in my project

    Then user uses this color in his project
      | red    |
      | black  |
      | orange |
      | green  |
      | yellow |
      | purple |
      | pink   |
      | blue   |
      | green  |
      | cyan   |

 @pets
  Scenario: List of the pets they love
    Then I will share their favorites

      | Kangla           |
      | Husky            |
      | Golden Retriever |
      | Munchkin         |
      | Ragdoll cat      |
      | Siberian cat     |


  Scenario: Office reads data about driver
    Then officer is able to see any data he wants

      | name    | Jane       |
      | surname | Doe        |
      | age     | 29         |
      | city    | Pittsburgh |
      | state   | CA         |
      | zipcode | 12342      |


  Scenario: User should be able to see all 12 months in months dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |













