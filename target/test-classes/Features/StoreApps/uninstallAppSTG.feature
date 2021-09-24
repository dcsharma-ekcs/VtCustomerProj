Feature: features to test uninstall app functionality

  @smoke
  Scenario Outline: UnInstall App Functionality

    Given user on login partners shopify page
    When user is enter <email> and <password> and <storename> and <appname>
    When user navigated to dashboard
    And click on stores and search and login in store
    When click on apps
    When user find and delete app
    Then user give feedback and click delete

    Examples:
      | email                      | password         | storename    | appname                     |
      | vnext_cloud@trustvesta.com | @dM!nShopify007! | TestStoreSGT | Vesta Payment Guarantee-Stg |