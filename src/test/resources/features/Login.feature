Feature: Validate that the user can log in correctly

Scenario: the user can log in correctly

Given navigate the paris page
When click on the login button
Then enter your email
Then enter your password
And click on the enter button
Then see the welcome message

