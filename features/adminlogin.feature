@adminlogin

Feature: admin log in

Scenario: login using valid details

Given user is in the Admin page
When enter login as "<login>" and password as "<password>"
Then he should be navigates to admin menu page

Examples:
|	login	|	password	|
|	admin	|	admin		|

Scenario: login using valid password in upercase

Given user is in the Admin page
When enter login as "<login>" and uppercase password as "<password>"
Then he should not be navigated to admin menu page

Examples:
|	login	|	password	|
|	admin	|	ADMIN		|

Scenario: login using invalid details

Given user is in the Admin page
When enter invalid login as "<login>" and invalid password as "<password>"
Then he should not be navigated to admin menu page after using invalid details

Examples:

|	login	|	password	|
|	ewkfbew	|	ewkbjf		|
