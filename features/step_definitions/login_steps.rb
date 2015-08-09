require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/swinger/lib/swinger'

Given(/^there is an existing user named "(.*?)" and password "(.*?)"$/) do |user_name, password|

end

When(/^login with user name "(.*?)" and password "(.*?)"$/) do |user_name, password|
  	container.set frame('WordPress-Swing')
  	text_field('user_name').text = user_name
  	password_field('password').text = password
  	text_field('host_site').text = 'http://172.28.128.3'
	button("login").do_click()
end

Then(/^login successfully$/) do
	container.set frame('Dashboard')
	label('Dashboard')
end