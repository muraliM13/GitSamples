Feature:  Place order
Background: User Login
Given User is on login page
When user enters "standard_user" and "secret_sauce"
Then User shold be on Home page

Scenario: Add Item to cart
Given User should be on Home page
When User add Item to cart
Then Item must be added

Scenario: Checkout Order
Given User is on cart page
When User do checkout
Then Should navigate to checkout page

Scenario: delete an Item
Given Cart must have Items
When User delete an Item
Then Should delete an item from cart



