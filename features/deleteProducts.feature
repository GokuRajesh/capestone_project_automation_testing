@delete

Feature: deleting products in admin page

Scenario: delete a product to the product list

Given user is in the Admin page, enter login as "<login>" and password as "<password>"
When he deletes the "<productname>","<category>"
Then the product is deleted

Examples:
|	login	|	password	|	productname			|	category	|
|	admin	|	admin		|	book of java		|	Programming	|
|	admin	|	admin		|	book of java		|	Programming	|