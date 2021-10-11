Feature: features to test initiate transaction functionality


  Scenario Outline: Transaction Functionality

    Given user on my shopify store page
    When  user is with <url> and <password>
    And click on enter button
    When user is navigated to store home page
    And click on catalog
    When user add product in card
    And click on buy it now
    When user fill contact information
    And click on continue to shipping
    When user choose a shipping method
    And click on continue to payment
    When user fill credit card detail
    And click on pay now button
    Then user is navigated to order detail page

    Examples:
      | url                                    | password |
      | https://teststg05102021.myshopify.com/ | vowgah   |



