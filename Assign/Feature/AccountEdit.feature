Feature: Salesforce Test cases

Scenario: Account Edit check
Given Launch the browser and Load the salesforce 'https://login.salesforce.com'
When Enter the salesforce username as 'dilip@testleaf.com'
And Enter the salesforce password as 'leaf@2024'
And Click on Salesforce login button
And Click on toggle menu buttonon the left corner
And Click view All and click All Apps dropdown
And Select Accounts from All Items section
And Search for Account 'Naveen Kumar' which needs to be edited
And Click on the Account name
And Click the dropdown on right side and select Edit option
And Enter the Phone number as '9090808070' 
And Set the Type as Technology partner and Industry as Healthcare
And Enter the billing address as 'No-10, 10th cross, Chennai-10'
And Enter the shipping address as 'No-11, 11th cross, Chennai-11'
And Set the Customer priority as Low and SLA as Silver
And Set the Active as No and upsell opportunity as No
And Click on Save button
Then Verify the Phone number '9090808070'