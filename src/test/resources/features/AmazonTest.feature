Feature: Automate Amazon search functionality

  Scenario: Validate Amazon search suggestions and product details
    Given I open Amazon in Chrome browser
    When I select "Electronics" from the dropdown and type "IPhone 13"
    Then I should see suggestions related to "IPhone 13"
    When I type "IPhone 13 128 GB" and select the "IPhone 13 128GB" variant from suggestions
    When I navigate to the new tab and click on Visit the Apple Store link
    Then I should select "Apple Watch SE (GPS + Cellular)" from the dropdown
    And I hover over the watch image and validate Quick Look modal is displayed
    Then the modal should display details of the correct product