Feature: features to test install app functionality

  @positiveScenario
  Scenario Outline: Install App Functionality

    Given user on login partners shopify page
    When user is enter <email> and <password> and <storeName> and <appName>
    When user navigated to dashboard
    And login in to store
    And click on apps and search app
    When user find app and click
    When user on apps detail page click select store button
    When user on search store page
    And search store and click on link install
    When user on app detail page
    And click install unlisted app
    Then user is navigated to b2c login page

    Examples:
      | email                      | password      | storeName       | appName                      |
      | reymundo.paga@ubiquity.com | !Password@123 | DevTest02102021 | Payment Guarantee by Vesta X |