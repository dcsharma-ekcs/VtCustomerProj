Feature: features to test initiate for digital products transaction functionality


  Background: Transaction Functionality
    Given user on my shopify store page "chrome"
    When  user is login in to store with "https://dcpulsetxnstg.myshopify.com/" and "plauly"
    And click on enter button
    When user is navigated to store home page
    And click on catalog
    And user search and add product in card "Chequered Red Shirt" quantity 2

  @smoke1
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
      | data_file_for_digital_products_new.xlsx | 1         |
      | data_file_for_digital_products_new.xlsx | 2         |

  @smoke
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
      | data_file_for_digital_products_new.xlsx | 1         |









