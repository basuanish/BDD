Feature: Using Loan Request Feature for Pecunia Bank Interface




#with Examples Keyword

Scenario Outline: Adding Loan Details 
    Given user is on the homepage
    When user clicks on Loan request option
    And user navigates to Loan request Page
    And user enters "<accountId>","<loanAmount>","<tenure>","<creditScore>","<interestRate>","<loanType>","<loanStatus>"
    And clicks the submit button
    Then user gets loan request added pop-up

Examples:
      | accountId | loanAmount | tenure | creditScore | interestRate | loanType | loanStatus |
	  | 100303000001 | 500000 | 24 | 800 | 8.5 | Personal Loan | Pending |
	