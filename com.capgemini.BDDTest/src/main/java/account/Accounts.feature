Feature: Using Account Feature for Pecunia Bank Interface 


#with Examples Keyword


		
Scenario Outline: Update contact details of customer
    Given user is on the homepage 
	When user navigates to account Page 
	And user clicks on Update contact details 
	And user navigates to Update contact details 
	And user enters valid "<accountid>" and "<contact>" 
	And clicks the update contact button 
	Then user gets a successfully message 
	
	Examples: 
		|accountid|contact |
		| 100101000002|5423296005|
		
	