Feature: features to test initiate for digital products transaction functionality


  Background: Transaction Functionality
    Given user on my shopify store page
    When  user is login in to store with url and password
    And click on enter button
    When user is navigated to store home page
    And click on catalog
    And user search and add product in card "Digital Products X01" quantity 2

  @smoke
  Scenario Outline: Transaction buy it now Functionality

    When click on buy it now
    And user fill checkout email or phone from <ExcelFileName> and <RowNumber>
    When user fill billing address from <ExcelFileName> and <RowNumber>
    And click on continue to payment
    When user fill credit card detail
    And click on pay now button
    Then user is navigated to order detail page

    Examples:
      | ExcelFileName                           | RowNumber |
      | CustomerDetails_XLSX_10.xlsx | 1         |


  @smoke1
  Scenario Outline: Transaction add to card Functionality

    When click add to card
    And click check out
    And user fill checkout email or phone from <ExcelFileName> and <RowNumber>
    When user fill billing address from <ExcelFileName> and <RowNumber>
    And click on continue to payment
    When user fill credit card detail
    And click on pay now button
    Then user is navigated to order detail page

    Examples:
      | ExcelFileName                           | RowNumber |
      | CustomerDetails_XLSX_10.xlsx | 1         |









