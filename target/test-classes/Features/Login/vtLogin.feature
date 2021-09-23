Feature: features to test vt login functionality

  @positiveScenario
  Scenario Outline: Login Functionality

    Given vt user login on url "https://vt-customer-stg.azurewebsites.net" with browser "chrome"
    When vt user is enter <username> and <password>
    And click on vt login button
    Then user is navigated to the vt home page

    Examples:
      | username                | password         |
      | cehedem117@posiklan.com | PCopperDc@!2611@ |

  @negativeScenario
  Scenario Outline: Login Functionality

    Given vt user login on url "https://vt-customer-dev.azurewebsites.net" with browser "chrome"
    When vt user is enter <username> and <password>
    And click on vt login button
    Then error message "Password or e-mail address is incorrect, please try again." should throw

    Examples:
      | username                | password         |
      | cehedem117@posiklan.com | WPCopperDc@!2611@ |