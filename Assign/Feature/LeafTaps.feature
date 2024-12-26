Feature: LeafTaps account related Test cases

Scenario Outline: Create Account Test case
When Click on leaftaps Accounts Tab
And Click on create account in shortcut section  
And Enter Account name as <accName>
And Enter the number of employee as <noOfEmp>
And Select the Industry as <indus> 
And Enter description as <description>
And Enter phone number as <phoneNum>
And Select the state as <state>
And Click on account save button
Then Verify the Account got created

Examples:
|accName|noOfEmp|indus|description|phoneNum|state|
|'Naveen Kumar02'|'10'|'Telecommunications'|'Hello Christmas'|'9090808070'|'New York'|

Scenario Outline: Edit Account Test case
When Click on leaftaps Accounts Tab
And Click on find Account in shortcut section
And Click on phone tab
And Enter the phone number <phoneNum> and click on find accounts button
And Click on the first account which needs to be edited
And Click on account edit button
And Clear the description value
And Enter the important not as <impNote>
And Click on account save button
Then Verify the Account got edited successfully

Examples:
|phoneNum|impNote|
|'9090808070'|'Christmas special Account'|

Scenario Outline: Delete Account Test case
When Click on leaftaps Accounts Tab
And Click on find Account in shortcut section
And Click on phone tab
And Enter the phone number <phoneNum> and click on find accounts button
And Store the first account id and click on it
And Click on Deactivate Account
And Accept the alert
Then Verify that Account got deleted successfully

Examples:
|phoneNum|
|'9090808070'|