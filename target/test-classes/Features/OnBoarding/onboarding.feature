Feature: features to test on boarding functionality

  @positiveScenario
  Scenario: On Boarding Functionality

    Given vt user is on customer portal login page
    When vt user is enter username and password
    And click on vt login button
    Then user is navigated to the vt home page
    And user click on describe your business
    And user go live
    Then user check progressbar status


