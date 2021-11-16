Feature: features to test on boarding functionality

  @positiveScenario
    @smoke
  Scenario Outline: On Boarding Functionality

    Given vt user is on customer portal login page
    When vt user is enter username and password
    And click on vt login button
    Then user is navigated to the vt home page
    And user click on describe your business
    And user set verticals <merchantVertical> and sub verticals <merchantSubVertical>
    And user set payment processor <paymentProcessor>
    And user go live
    Then user check progressbar status
    When user click on account management tab
    And user search merchant <merchantName> by search field
    And user get and check merchant tage status <strStatus>
    And user click merchant detail button
    And user check merchant vertical <merchantVertical>
    And user check merchant sub vertical <merchantSubVertical>
    And user check payment processor <paymentProcessor>

    Examples:
      | merchantName   | strStatus | merchantVertical | merchantSubVertical | paymentProcessor |
      | TestInt11NovS1 | Now Live  | Event Tickets    | Virtual             | Atome            |


  @smoke1
  Scenario Outline: On Boarding Functionality1

    Given vt user is on customer portal login page
    When vt user is enter username and password
    And click on vt login button
    When user click on account management tab
    And user search merchant <merchantName> by search field
    And user get and check merchant tage status <strStatus>
    And user click merchant detail button
    And user check merchant vertical <merchantVertical>
    And user check merchant sub vertical <merchantSubVertical>
    And user check payment processor <paymentProcessor>

    Examples:
      | merchantName   | strStatus | merchantVertical | merchantSubVertical | paymentProcessor  |
      | TestInt09NovS2 | Now Live  | Telco            | Carrier - Top Up    | WorldPay (Direct) |


  @smoke1
  Scenario Outline: On Boarding Functionality

    Given vt user is on customer portal login page
    When vt user is enter username and password
    And click on vt login button
    Then user is navigated to the vt home page
    And user click on describe your business
    And user set verticals <merchantVertical> and sub verticals <merchantSubVertical>
    And user set payment processor <paymentProcessor>

    Examples:
      | merchantName   | strStatus | merchantVertical | merchantSubVertical | paymentProcessor  |
      | TestInt09NovS2 | Now Live  | Telco            | Carrier - Top Up    | WorldPay (Direct) |


