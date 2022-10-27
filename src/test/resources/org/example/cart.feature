Feature: Saucedemo webshop cart testing

  Background:
    Given the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the Login button is clicked

    Scenario:
      Given the Sauce Labs Backpack is added to the cart
      And the cart icon is clicked
      And the checkout button is clicked
      And the First Name is filled with 'A'
      And the Last Name is filled with 'B'
      And the Zip Code is filled with '1234'
      When the Continue button is clicked
      Then 'Total: $32.39' should be shown
