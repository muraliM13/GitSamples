
Feature: Book search for
https://danube-webshop.herokuapp.com/

Scenario: Novels & Stories search test
Given User is on Home Page
When User search Novels & Stories
Then Should display novel result page

Scenario: Crime & Thrillers search test
Given User is on Home Page
When User search Crime & Thrillers
Then Should display Crime & Thrillers result page