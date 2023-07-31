Feature: Ebay Filter Search

  Scenario: Given filters are applied
      Given I launch chrome browser
      When I open Ebay homepage
      Then I verify that the logo is present on the page
      Then I navigate to cell phones and smartphones
      Then I apply the filters
      And close the browser




