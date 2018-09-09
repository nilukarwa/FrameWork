Feature: Login
Scenario: Login valid data
Given When I am on the Tricentis login page
When I give abc and xyz
And I click on login button
Then I should be able to login