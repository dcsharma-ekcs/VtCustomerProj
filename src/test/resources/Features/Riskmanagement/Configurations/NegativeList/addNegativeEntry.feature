Feature: features to test add positive entry

  @positiveScenario
  Scenario Outline: Add Positive Entry Functionality

    Given vt user on login page with browser "chrome"
    When vt user is enter <username> and <password>
    And click on vt login button
    When user on dashboard page
    And click on Risk Management
    And click on configurations
    And click on Positive Negative List
    When user on Configurations Page
    And click on Negative Button
    And click on Add Negative Entry
    When open Add New Entry Form
    And user Fill Add New Entry Form <CSVfile> and <rowNumber>
    And click on Add New Entry Create Button
    Then user is navigated to Configurations page

    Examples:
      | username                | password      | CSVfile                               | rowNumber |
      | mavejen717@enamelme.com | Dcsharma@2020 | /datafiles/csvAddNewNegativeEntry.csv | 1         |


