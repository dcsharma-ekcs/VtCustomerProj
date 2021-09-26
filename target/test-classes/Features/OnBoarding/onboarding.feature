Feature: features to test on boarding functionality

  @positiveScenario
  Scenario Outline: On Boarding Functionality

    Given vt user login on url "https://vt-customer-stg.azurewebsites.net" with browser "chrome"
    When vt user is enter <username> and <password>
    And click on vt login button
    Then user is navigated to the vt home page
    And user click on describe your business
    And user go live
    Then user check progressbar status

    Examples:
      | username                | password         |
      | cehedem117@posiklan.com | PCopperDc@!2611@ |

