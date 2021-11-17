Feature: features to test vt login functionality

  @positiveScenario
  @smoke
  Scenario: Successful Login with Valid Credentials Functionality

    Given vt user is on customer portal login page
    When vt user is enter username and password
    And click on vt login button
    Then user is navigated to the vt home page



  @negativeScenario
  @smoke
  Scenario: Login with Invalid Credentials Functionality

    Given vt user is on customer portal login page
    When vt user is enter username and wrong password
    And click on vt login button
    Then error message "Password or e-mail address is incorrect, please try again." should throw

