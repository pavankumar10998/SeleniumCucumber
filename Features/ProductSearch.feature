Feature: Ebay Product Search

  Scenario: Entered product is searched
    Given I launch chrome browser
    When I open Ebay homepage
    Then I verify that the logo is present on the page
    Then I search for MacBook
    Then I ensure the page loads completely
    Then I verify that the first result name matches with the search string
    And close the browser
