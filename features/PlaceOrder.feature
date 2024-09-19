Feature: Login to the First Cry Webpage

@CheckOut
Scenario: User should be able to login with valid credentials
Given user visit the First Cry website
And user click on Login button
When user enter Username as <username> and otp into the fields
And user click on submit button
Then user should get logged in
When user is on homepage
And user click on a catagory
And user select few product
When user clicks on cart button
Then user should be able to see products in the cart
When user click on Add Delivery Address
And user gives  contact details
And user clicks on save address and then on place order
And select COD as mode of payment
Then Order should get placed
Examples:
|username										|
|hamza.ansari575@gmail.com	|