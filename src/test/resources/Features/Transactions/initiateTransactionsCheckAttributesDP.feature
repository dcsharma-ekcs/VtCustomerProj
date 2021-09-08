Feature: features to test initiate for digital products transaction and risk management functionality


  Background: Transaction Functionality
    Given user on my shopify store page
    When  user is login in to store with "https://amit-test-04-09-01.myshopify.com/" and "lohyau"
    And click on enter button
    When user is navigated to store home page
    And click on catalog
    When user search and add digital product in card "digital products 002"

  @smoke1
  Scenario Outline: Transaction buy it now Functionality

    When click on buy it now
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

    When click add to card and check out
    When user fill billing address from <ExcelFileName> and <RowNumber>
    And click on continue to payment
    When user fill credit card detail
    And click on pay now button
    Then user is navigated to order detail page
    When user login to vt customer portal "https://vt-customer-dev.azurewebsites.net" user "mavejen717@enamelme.com" and password "Dcsharma@2020"
    And navigate to risk management list page
    And search order with order id
    And click for transaction summary
    And check positive negative attributes
    Then user logout

    Examples:
      | ExcelFileName                           | RowNumber |
      | CustomerDetails_XLSX_10.xlsx | 2         |

    







