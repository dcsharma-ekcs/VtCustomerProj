Feature: features to test initiate transaction for physical products functionality


  Background: Transaction Functionality
    Given user on my shopify store page "chrome"
    When  user is login in to store with "https://dcprdtest02.myshopify.com/" and "bieris"
    And click on enter button
    When user is navigated to store home page
    And click on catalog
    When user add product in card

 @smoke1
  Scenario Outline: Transaction buy it now Functionality

    When click on buy it now
   And user fill checkout email or phone from <ExcelFileName> and <RowNumber>
    When user fill contact information from <ExcelFileName> and <RowNumber>
    And click on continue to shipping
    When user choose a shipping method
    And click on continue to payment
    When user fill credit card detail
    And click on pay now button
    Then user is navigated to order detail page

    Examples:
      | ExcelFileName                | RowNumber |
      | CustomerDetails_XLSX_10.xlsx | 1         |
      | CustomerDetails_XLSX_10.xlsx | 2         |

  @smoke
  Scenario Outline: Transaction add to card Functionality

    When click add to card
    And click check out
    And user fill checkout email or phone from <ExcelFileName> and <RowNumber>
    When user fill contact information from <ExcelFileName> and <RowNumber>
    And click on continue to shipping
    When user choose a shipping method
    And click on continue to payment
    When user fill credit card detail
    And click on pay now button
    Then user is navigated to order detail page

    Examples:
      | ExcelFileName                | RowNumber |
      | CustomerDetails_XLSX_10.xlsx | 4         |







