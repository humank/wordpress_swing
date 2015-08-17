Feature: Login

  Scenario: Login Successfully
	Given there is an existing user named "odd-e" and password "s3cr3t"
	When login with user name "odd-e" and password "s3cr3t"
	Then login successfully

  Scenario: Login Failed with wrong password
    Given there is an existing user named "odd-e" and password "s3cr3t"
	When login with user name "odd-e" and password "wrong_password"
	Then login failed with error "incorrect user name or password"

  Scenario Outline: Login Failed even before authentication
	When login with user name "<user_name>" and password "<password>"
	Then login failed with error "<message>"
	Examples:
	|user_name		|password 		|message				|
	|				|anyPassword	|please input user name |
	|anyUserName	|				|please input password  |

