Feature: Using Account Feature for Pecunia Bank Interface 


#with Examples Keyword


		
Scenario Outline: Add account 
	
	Given user is on the homepage 
	When user navigates to account Page 
	And user clicks on add account option 
	And user navigates to add account page 
	And user enters valid "<name>","<dateofBirth>","<addressLine1>","<addressLine2>","<city>","<state>","<country>","<zipCode>","<aadhar>","<pan>","<accountType>","<branchId>","<balance>","<interest>","<gender>","<contact>" 
	And clicks the add new account button 
	Then user gets account created successfully message 
	
	Examples: 
		| name | dateofBirth | addressLine1 | addressLine2 | city | state | country | zipCode | aadhar | pan | accountType | branchId |balance | interest | gender | contact |
		| Manish | 07-03-1997 | Mishti sweets| near mahesh tower | Kolkata | West Bengal| India | 110022| 821388450295 | JLKHP7890Q| Savings| 1002| 678| 6| Male| 9040095402|
		
	