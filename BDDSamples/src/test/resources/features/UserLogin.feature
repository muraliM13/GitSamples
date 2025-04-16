Feature: User Login Page
#Scenario: Valid Login Admin
#Given User is on Login Page
#user provided values
#When User enters "tomsmith" and "SuperSecretPassword!" 
#hardcoded in stepdef
#When User enters credentials		
#Then Should Display success message


# second scenario
#Scenario Outline: Valid Login Admin
#Given User is on Login Page
#When User enters "<username>" and "<password>" 
#Then Should Display success message

#Examples:
#| username | password |
#| tomsmith | SuperSecretPassword! |
#| tomsmith | SuperSecretPassword12! |
#| tomsmith12 | SuperSecretPassword! |


#3rd scenario
Scenario Outline: Valid Login Admin
Given User is on Login Page
When User enters credentials
| tomsmith | SuperSecretPassword! | 
Then Should Display success message
| You logged into a secure area!|
