Feature: Login functionality

@smoke
Scenario: To verify Login with valid credentials

Given user is in Login page

When user enters valid username "admin" and password "manager"

And clicks on Login button

Then Home page should be displayed "actiTIME - Enter Time-Track"


@functional
Scenario: To verify order is placed

When user selects the "mode" of transaction
 
Then order should be placed succesfully

|mode       |discount   |
|Credit Card|10%        |
|Debit Card |20%        |
|COD        |30%        |



