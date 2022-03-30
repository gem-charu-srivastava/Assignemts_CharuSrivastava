Feature: Application Login

Scenario Outline: Home page default login
Given User is on NetBanking landing page
When User login in to application with <Username> and password <password>
Then Home page is populated
And Cards displayed are "true"

  Examples:
    |Username |password|
    |user1    |pass1   |
    |user2    |pass2   |
    |user3    |pass3   |
    |user4    |pass4   |


