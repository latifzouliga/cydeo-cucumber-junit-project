Feature: Librirain User Adding Feature

  @wip
  Scenario:
    Given the "librarian" on the home page
    And the librarian navigates to "Users" page
    When the librarian clicks to Add User
    And the librarian enters fullname "HelloMan123"
    When the librarian enters password "T123424"
    And the librarian enters email "hello123@hello.com"
    And the librarian clicks to save changes
    Then verify "The user has been created." message is displayed
    And verify created user with "hello123@hello1.com" and "Test123424" able to login
    And verify created user should be able to see "HelloMan123"
  #libraryUrl=https://library2.cydeo.com
  #librarian_username=librarian10@library
  #librarian_password=libraryUser