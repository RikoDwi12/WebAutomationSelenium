Feature: Buyer Login To Ecommerce

  Background: Buyer landed to website
    Given Buyer landing to ecommerce

  Scenario Outline: Login Negative Case
    Given Buyer logged to website email <email> and password <password>
    Then Buyer should see login error message "Epic sadface: Username and password do not match any user in this service"

    Examples:
      | email         | password     |
      | standard_user | problem      |
      | problem       | secret_sauce |

  Scenario Outline: Login Positive Case
    Given Buyer logged to website email <email> and password <password>
    Then Buyer should be redirected to the inventory page

    Examples:
      | email         | password     |
      | standard_user | secret_sauce |
