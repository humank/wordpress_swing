Given(/^there is an existing user named "(.*?)" and password "(.*?)"$/) do |user_name, password|
end

When(/^login with user name "(.*?)" and password "(.*?)"$/) do |user_name, password|
	timeout('DialogWaiter.WaitDialogTimeout',1000)
  	container.set frame('WordPress-Swing')
  	text_field('user_name').text = user_name
  	password_field('password').text = password
	button("login").do_click()
end

Then(/^login successfully$/) do
	container.set frame('Dashboard')
	expect(label('Dashboard').visible?).to eq(true)
end

Then(/^login failed with error "([^"]*)"$/) do |error_message|
	expect(dialog(error_message).visible?).to eq(true)
end