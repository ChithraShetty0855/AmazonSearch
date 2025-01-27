Feature: Automate Amazon search functionality

  Background:
    Given I open Amazon in browser

  Scenario: Validate Amazon search suggestions and product details
    When I select "Electronics" from the dropdown and type "IPhone 13"
    Then I should see suggestions related to "IPhone 13"
    When I type "IPhone 13 128 GB" and select the "IPhone 13 128GB" variant from suggestions
    When I navigate to the new tab and click on Visit the Apple Store link
    Then I should select "Apple Watch SE (GPS + Cellular)" from the dropdown
    And I hover over the watch image and validate Quick Look modal is displayed
    Then the modal should display details of the correct product