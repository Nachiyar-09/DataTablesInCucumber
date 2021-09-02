Feature: Login Functionality
 Scenario: User test the login page for its conditions
     Given User is on Home Page
	 When User Navigate to LogIn Page
	  And User enters credentials to login
	      | Admin | admin123 |
	Then Message displayed Login Successfull

