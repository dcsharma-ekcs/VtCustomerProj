Feature: features to test merchant create new users

  @positiveScenario
  Scenario Outline: Create New Users Functionality

    Given vt user is on customer portal login page
    When vt user is enter username and password
    And click on vt login button
    Then user is navigated to the vt home page
    When user click on account management tab
    And user click on users tab
    And user click on add new user button
    And user fill add user form with role <userRole> and save

    Examples:
      | userRole  |
      | Fraud Ops |
      | Default   |
      | Admin     |
      | Reviewer  |






