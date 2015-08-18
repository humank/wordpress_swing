Feature: Comment

	Scenario: Only logined user can post comment to a blog
		Given a subscriber "Mary" logined
		When she comments a post "Learning Objectives" with comment "a nice post"
		Then other subscriber "Peter" can see this comment
