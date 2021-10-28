Feature: features to test initiate transaction for physical products functionality


  Background: Transaction Functionality
    Given user on my shopify store page
    When  user is login in to store with url and password
    And click on enter button
    When user is navigated to store home page
    And click on catalog


  @smoke
  Scenario Outline: Transaction buy it now Functionality

    And user search and add product in card "Chequered Red Shirt" quantity 2
    When click on buy it now
    And user fill checkout email or phone from <ExcelFileName> and <RowNumber>
    When user fill contact information from <ExcelFileName> and <RowNumber>
    And click on continue to shipping
    When user choose a shipping method
    And click on continue to payment
    And user click use a different billing address
    When user fill credit card detail
    And user fill billing address from <ExcelFileName> and <RowNumber>
    And click on pay now button
    Then user is navigated to order detail page
    When user login to vt customer portal url username and password
    And navigate to risk management list page
    And search order with order id
    And click for transaction summary
    And check attributes positive negative
    And check billing and shipping details
    And check shopping cart
    And check payment device and auth
    And check map information
    Then user logout


    Examples:
      | ExcelFileName                | RowNumber |
      | CustomerDetails_XLSX_10.xlsx | 1         |


  @smoke
  Scenario Outline: Transaction add to card Functionality

    And user search and add product in card "Chequered Red Shirt" quantity 2
    And click add to card
    And user search and add product in card "Blue Silk Tuxedo" quantity 3
    And click add to card
    And click check out
    And user fill checkout email or phone from <ExcelFileName> and <RowNumber>
    When user fill contact information from <ExcelFileName> and <RowNumber>
    And click on continue to shipping
    When user choose a shipping method
    And click on continue to payment
    When user fill credit card detail
    And click on pay now button
    Then user is navigated to order detail page
    When user login to vt customer portal url username and password
    And navigate to risk management list page
    And search order with order id
    And click for transaction summary
    And check attributes positive negative
    And check billing and shipping details
    And check shopping cart
    And check payment device and auth
    And check map information
    Then user logout


    Examples:
      | ExcelFileName                | RowNumber |
      | CustomerDetails_XLSX_10.xlsx | 4         |


  @smoke1
  Scenario: Transaction check validate summary Functionality

    When user login to vt customer portal url username and password
    And navigate to risk management list page
    And search order with order id
    And click for transaction summary
    And check attributes positive negative
    And validate risk score and status
    Then user logout










