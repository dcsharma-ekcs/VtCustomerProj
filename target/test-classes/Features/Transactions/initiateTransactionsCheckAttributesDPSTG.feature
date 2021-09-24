Feature: features to test initiate for digital products transaction and risk management functionality


  Background: Transaction Functionality
    Given user on my shopify store page "chrome"
    When  user is login in to store with "https://dcpulsetxnstg.myshopify.com/" and "plauly"
    And click on enter button
    When user is navigated to store home page
    And click on catalog
    When user search and add product in card "digital products X02" quantity 2

  @smoke1
  Scenario Outline: Transaction buy it now Functionality

    When click on buy it now
    And user fill checkout email or phone from <ExcelFileName> and <RowNumber>
    When user fill billing address from <ExcelFileName> and <RowNumber>
    And click on continue to payment
    When user fill credit card detail
    And click on pay now button
    Then user is navigated to digital order detail page
    When user login to vt customer portal "https://vt-customer-stg.azurewebsites.net" user "cehedem117@posiklan.com" and password "PCopperDc@!2611@"
    And navigate to risk management list page
    And search order with order id
    And click for transaction summary
    And check attributes positive negative
    Then user logout

    Examples:
      | ExcelFileName                           | RowNumber |
      | data_file_for_digital_products_new.xlsx | 1         |


  @smoke
  Scenario Outline: Transaction add to card Functionality

    And click add to card
    And click check out
    And user fill checkout email or phone from <ExcelFileName> and <RowNumber>
    When user fill billing address from <ExcelFileName> and <RowNumber>
    And click on continue to payment
    When user fill credit card detail
    And click on pay now button
    Then user is navigated to digital order detail page
    When user login to vt customer portal "https://vt-customer-stg.azurewebsites.net" user "cehedem117@posiklan.com" and password "PCopperDc@!2611@"
    And navigate to risk management list page
    And search order with order id
    And click for transaction summary
    And check attributes positive negative
    Then user logout

    Examples:
      | ExcelFileName                | RowNumber |
      | CustomerDetails_XLSX_10.xlsx | 2         |

    







