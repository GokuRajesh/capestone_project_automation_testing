@searchproduct

Feature: Search Product 

Scenario: Search valid product in all

Given the user in the Home page
When he searches product in category all as "<validproduct>"
Then he should be able to view the product "<validproduct>"

Examples:
|	validproduct						|
|	Perl and CGI for the World Wide Web	|
|	Oracle8i Web Development			|
|	Web Design in a Nutshell			|

Scenario: Search in valid product in all

Given the user in the Home page
When he searches invalid product in category all as "<invalidproduct>"
Then he should be able to view no record found 

Examples:
|	invalidproduct						|
|	wkefbiwejbfiw						|

