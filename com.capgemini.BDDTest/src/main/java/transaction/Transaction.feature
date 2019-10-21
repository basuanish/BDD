Feature: Using Transaction Feature for Pecunia Bank Interface


#with Examples Keyword

Scenario Outline: Credit using Slip
    Given user is  on homepage
    When user navigates to Transaction Page
    And user clicks on credit using slip option
    And user navigates to credit using slip page
    And user enters valid "<accountNumber>" and "<amount>"
    And clicks submit button
    Then user gets a credit using slip success message

Examples:
	| accountNumber | amount |
	| 100303000001 | 1100 |
	
	

