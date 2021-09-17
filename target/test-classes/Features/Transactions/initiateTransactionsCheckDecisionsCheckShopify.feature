Feature: features to test initiate transaction for physical products functionality


  Background: Transaction Functionality
    Given user on my shopify store page "chrome"
    When  user is login in to store with "https://amit-test-04-09-01.myshopify.com/" and "lohyau"
    And click on enter button
    When user is navigated to store home page
    And click on catalog


  @smoke
  Scenario Outline: Transaction buy it now Functionality

    And user search and add product in card "Chequered Red Shirt" quantity 0
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
    When user login to vt customer portal "https://vt-customer-dev.azurewebsites.net" user "mavejen717@enamelme.com" and password "Dcsharma@2020"
    And navigate to risk management list page
    And search order with order id
    And click for transaction summary
    And check order status
    And click decisions tab
    And search store "Amit-Test-04-09-01" for get decisions settings
    And user logout
    When user navigate to partners shopify page
    When user login with "reymundo.paga@ubiquity.com" and "!Password@123" and "Amit-Test-04-09-01"
    And shopify search and login in store
    And click on store tab
    And search order in shopify with order id
    And Check order payment status



    Examples:
      | ExcelFileName                | RowNumber |
      | CustomerDetails_XLSX_10.xlsx | 1         |


  @smoke1
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
    When user login to vt customer portal "https://vt-customer-dev.azurewebsites.net" user "mavejen717@enamelme.com" and password "Dcsharma@2020"
    And navigate to risk management list page
    And search order with order id
    And click for transaction summary
    And check order status
    And click decisions tab
    And search store "Amit-Test-04-09-01" for get decisions settings
    And user logout
    When user navigate to partners shopify page
    When user login with "reymundo.paga@ubiquity.com" and "!Password@123" and "Amit-Test-04-09-01"
    And shopify search and login in store
    And click on store tab
    And search order in shopify with order id
    And Check order payment status


    Examples:
      | ExcelFileName                | RowNumber |
      | CustomerDetails_XLSX_10.xlsx | 4         |


  @smoke1
  Scenario: Transaction decisions Functionality

    When user login to vt customer portal "https://vt-customer-dev.azurewebsites.net" user "mavejen717@enamelme.com" and password "Dcsharma@2020"
    And navigate to risk management list page
    And search order with order id
    And click for transaction summary
    And check order status
    And click decisions tab
    And search store "Amit-Test-04-09-01" for get decisions settings
    And user logout
    When user navigate to partners shopify page
    When user login with "reymundo.paga@ubiquity.com" and "!Password@123" and "Amit-Test-04-09-01"
    And shopify search and login in store
    And click on store tab
    And search order in shopify with order id
    And Check order payment status











