@addingproducts

Feature: Adding products in admin page

Scenario: adding a new product to the product list

Given user is in the Admin page, enter login as "<login>" and password as "<password>"
When he adds the product in the product list as "<category>" ,"<productname>" and "<price>"
Then the new product is added to the product list as "<productname>","<category>"

Examples:
|	login	|	password	|	category	|	productname		|	price	|
|	admin	|	admin		|	Programming	|	book of java	|	30		|

Scenario: adding a duplicate product to the product list

Given user is in the Admin page, enter login as "<login>" and password as "<password>"
When he adds the duplicate product in the product list as "<category>" ,"<productname>" and "<price>"
Then the "<productname>" is not added from "<category>"

Examples:
|	login	|	password	|	category	|	productname		|	price	|
|	admin	|	admin		|	Programming	|	book of java	|	30		|
	