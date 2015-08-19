Given(/^there is an existing user named "(.*?)" and password "(.*?)"$/) do |user_name, password|
end

When(/^login with user name "(.*?)" and password "(.*?)"$/) do |user_name, password|
	timeout('DialogWaiter.WaitDialogTimeout',1000)
  	container.set page_dialog('Sign in')
  	text_field('User Name: ').text = user_name
  	password_field('Password: ').text = password
  	text_field('WordPress Site: ').text = 'http://odd-pi.local'
	button("login").do_click()
end

Then(/^login successfully$/) do
	expect(page_dialog('Dashboard').visible?).to eq(true)
end

Then(/^login failed with error "([^"]*)"$/) do |error_message|
	container.set dialog("Error")
	expect(label(error_message).visible?).to eq(true)
end