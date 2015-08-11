Feature: Login

  Scenario: Login Successfully
	Given there is an existing user named "odd-e" and password "s3cr3t"
	When login with user name "odd-e" and password "s3cr3t"
	Then login successfully

  @ignore
  Scenario: Login Failed
    Given there is an existing user named "odd-e" and password "s3cr3t"
	When login with user name "odd-e" and password "wrong_password"
	Then login failed with error "incorrect user name or password"
