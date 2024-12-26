Feature: Salesforce Test cases

Scenario Outline: Sales Account creation
Given Launch the browser and Load the salesforce <url>
When Enter the salesforce username as <username>
And Enter the salesforce password as <password>
And Click on Salesforce login button
And Click on toggle menu buttonon the left corner
And Click view All and click Sales from App Launcher
And Click on Accounts Tab
And Click on New Account button
And Enter the Account name and no of Employees
And Select the ownership as public
And Click on save button
Then Verify the sales account creation

Examples:
|url|username|password|
|'https://login.salesforce.com'|'dilip@testleaf.com'|'leaf@2024'|

