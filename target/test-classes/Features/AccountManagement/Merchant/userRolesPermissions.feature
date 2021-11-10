Feature: features to test user roles permissions

  @positiveScenario
  Scenario Outline: User Roles Permissions Functionality

    Given vt user is on customer portal login page
    When vt user is enter username and password
    And click on vt login button
    Then user is navigated to the vt home page
    When user click on account management tab
    And user read top level feature for role <userRole>


    Examples:
      | userRole  |
      | Admin     |






