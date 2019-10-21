Feature: Using Passbook Feature for Pecunia Bank Interface




#with Examples Keyword
	
Scenario Outline: Account summary
    Given user is  on homepage
    When user navigates to the Passbook Page
    And user clicks on Account Summary option
    And user enters valid "<accountNumber>", "<startDate>","<endDate>"
    And taps on the submit button
    Then user gets the account summary

Examples:
	| accountNumber | startDate | endDate |
	| 100303000001 | 01/01/2019 | 10/05/2019 |