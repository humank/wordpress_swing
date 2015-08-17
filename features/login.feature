Feature: Login

  Scenario: Login Successfully
	Given there is an existing user named "odd-e" and password "s3cr3t"
	When login with user name "odd-e" and password "s3cr3t"
	Then login successfully

  Scenario: Login Failed with wrong password
    Given there is an existing user named "odd-e" and password "s3cr3t"
	When login with user name "odd-e" and password "wrong_password"
	Then login failed with error "incorrect user name or password"

  Scenario: Login Failed with empty user name
    Given there is an existing user named "odd-e" and password "s3cr3t"
	When login with user name "" and password "s3cr3t"
	Then login failed with error "please input user name"
