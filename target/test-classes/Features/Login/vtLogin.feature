Feature: features to test vt login functionality

  @positiveScenario
  Scenario Outline: Login Functionality

    Given vt user on login page
    When vt user is enter <username> and <password>
    And click on vt login button
    Then user is navigated to the vt home page

    Examples:
      | username | password  |
      | vesta_integration@trustvesta.com    | !@#asdfASDF123 |

  @negativeScenario
  Scenario Outline: Login Functionality

    Given vt user on login page
    When vt user is enter <username> and <password>
    And click on vt login button
    Then error message should throw

    Examples:
      | username | password  |
      | vesta_integration@trustvesta.com1    | !@#asdfASDF123 |