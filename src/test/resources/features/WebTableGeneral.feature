
Feature: Some of the general functionality verifications


  Scenario: Dropdown options verification
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees below options under product dropdown
      | MoneyCog   |
      | Familybea  |
      | Screenable |



  Scenario: Order place scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees Visa radio button is enabled


  Scenario: Order place scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees Mastercard radio button is enabled


  Scenario: Order place scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees American Express radio button is enabled



  Scenario: Order placement scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user enters appropriate test data
      | Product       | MoneyCog         |
      | Quantity      | 200              |
      | Customer name | karim MM         |
      | Street        | 222 Hello Street |
      | City          | Origan City      |
      | State         | PA               |
      | Zip           | 23423            |
      | Card type     | MasterCard       |

    #And user selects Visa
    #Then user Enter card infos
      | Card No       | 233249872342     |
      | Expire date   | 07/25            |

    And user clicks to Process Order
    Then user should see "karim MM" in the table on View all orders


  Scenario: Order placement scenario
    Given user is already logged in to The Web table app
    When user is on the Order page And user enters quantity "2"
    Then user clicks to the calculate button And user enters customer name "Jane Doe"
    And user enters street "7th Street"
    And user enters city "New York"
    And user enters state "New York"
    And user enters zip "99999"
    And user selects payment option "Visa"
    And user enters credit card number "1111222233334444"
    And user enters expiration date "12/25"
    And user clicks to process order button
    Then user should see "Jane Doe" in the first row of the web table I


  Scenario Outline: Order placement scenario
    Given user is already logged in to The Web table app
    When user is on the Order page And user enters quantity "<Quantity>"
    Then user clicks to the calculate button And user enters customer name "<Customer Name>"
    And user enters street "<Street>"
    And user enters city "<City>"
    And user enters state "<State>"
    And user enters zip "<Zip Code>"
    And user selects payment option "<Card Type>"
    And user enters credit card number "<Card Number>"
    And user enters expiration date "<Expiry Date>"
    And user clicks to process order button
    Then user should see "<Expected Name>" in the first row of the web table I

    Examples:

      | Quantity | Customer Name | Street         | City        | State | Zip Code | Card Type        | Card Number   | Expiry Date | Expected Name |
      | 12       | Latif         | 3454 Hi Street | Morgan town | Pa    | 23223    | MasterCard       | 2343423423423 | 23/32       | Latif        |
      | 23       | Abdellatif    | Amigo Dr       | Hello City  | CA    | 65222    | American Express | 234234234234  | 12/23       | Abdellatif    |
      | 400      | Ahlam         | Amigo Dr       | Hello City  | CA    | 65222    | Visa             | 234234234234  | 12/23       | Ahlam         |



  Scenario: Delete an order
  Given user is already logged in to The Web table app
    When user select an "Bob Martin" from the table
    Then user click delete selected button
    Then user should see the order disappear from the table


  Scenario: Delete all orders
    Given user is already logged in to The Web table app
    When user select all orders from the table
    Then user click delete selected button
    Then user should see an empty table

















