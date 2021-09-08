Feature: features to test add Store with store contact email functionality


  Scenario Outline: add store with store contact email Functionality

    Given user on login partners shopify page
    When user login with <email> and <password>
    When user navigated to dashboard
    And click on stores
    When user click on add store
    When user pick a store type <storeType> and set <storeName>
    And fill password and select store purpose
    And user click on save button
    When user change store general settings <storeContactEmail>
    Then user check store

    Examples:
      | email                      | password      | storeType           | storeName       | storeContactEmail       |
      | reymundo.paga@ubiquity.com | !Password@123 | Development store | new-india-store | timole2036@enamelme.com |