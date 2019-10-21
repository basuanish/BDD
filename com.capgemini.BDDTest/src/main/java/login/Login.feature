Feature: Login Feature for Pecunia Bank Interface




#with Examples Keyword

Scenario Outline: Login as a authenticated user
    Given user is on homepage
    When user navigates to Login Page
    And user enters "<username>" and "<password>"
    And clicks on the submit button
    Then user navigates to main page

Examples:
	| username | password |
	|  avishek@gmail.com     | 12345  |
		