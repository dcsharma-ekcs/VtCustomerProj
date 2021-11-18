Feature: features to test user roles permissions

  @positiveScenario
    @smoke1
  Scenario Outline: User Roles Permissions Functionality

    Given vt user is on customer portal login page
    When vt user is enter username <userName> and password <password>
    And click on vt login button
    Then user is navigated to the vt home page
    When user click on account management tab
    And user read top level feature for role <userRole>

    @smoke1
    Examples:
      | userName               | password        | userRole |
      #| wojadi4002@d3ff.com    | d5($5#yG46m3z'Y | Admin     |
      | sayafi6424@datakop.com | -ae"013(N518!Eu | Default  |
      #| molah83258@dukeoo.com  | "6,L41t3&)lX9FR | Fraud Ops |
      #| yavig41061@dukeoo.com  | 7V'00+%5Sgp%S32 | Reviewer  |






