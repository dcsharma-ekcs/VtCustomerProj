Feature: features to test merchant profile feature

  @positiveScenario
  Scenario Outline: Merchant Profile Configure Billing and Product Details

    Given vt user is on customer portal login page
    When vt user is enter username and password
    And click on vt login button
    Then user is navigated to the vt home page
    When user click on account management tab
    # And user search merchant <merchantName> by search field
    And user get and check merchant tage status <strStatus>
    And user click merchant detail button
    And user check merchant vertical <merchantVertical>
    And user check merchant sub vertical <merchantSubVertical>
    # And user check payment processor <paymentProcessor>
    And user click billing tab
    And user check merchant invoice currency <invoiceCurrency>
    And user check merchant billing address
    And user check billing end on date
    And user click product tab
    And user check merchant product details

    Examples:
      | merchantName    | strStatus | merchantVertical | merchantSubVertical | paymentProcessor | invoiceCurrency |
      | TestSTG05102021 | Now Live  | Physical Goods   | Jewelry             | Atome            | USD             |




