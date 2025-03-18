# 1 feat harus ada di scenario
Feature: Purchase the order from ecommerce

  Background: Buyer landed to website
    Given Buyer landing to ecommerce

  Scenario Outline: Create Order Positive Case
    Given Buyer logged to website email <email> and password <password>
    When Buyer add Product <ProductName> to cart
    And Buyer click checkout "<ProductName>"
    And Buyer fill the form with "<firstName>", "<lastName>", and "<postalCode>"
    And Buyer place order "<ProductName>"
    Then Buyer should see the order confirmation "Thank you for your order!"

    Examples:
      | email         | password     | ProductName         | firstName | lastName | postalCode |
      | standard_user | secret_sauce | Sauce Labs Backpack | John      | Doe      |      12345 |
      | standard_user | secret_sauce | Sauce Labs Onesie   | John      | Ke Dua   |      11232 |
