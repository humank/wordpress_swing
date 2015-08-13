require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/swinger/lib/swinger'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/commons-codec-1.2.jar'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/commons-httpclient-3.0.1.jar'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/commons-logging-1.0.3.jar'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/ws-commons-util-1.0.2.jar'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/xml-apis-1.0.b2.jar'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/xmlrpc-client-3.1.3.jar'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/xmlrpc-common-3.1.3.jar'

Given(/^there is an existing user named "(.*?)" and password "(.*?)"$/) do |user_name, password|
	timeout('DialogWaiter.WaitDialogTimeout',1000)
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
	expect(label('Dashboard').visible?).to eq(true)
end

Then(/^login failed with error "([^"]*)"$/) do |error_message|
	container.set dialog(error_message)
	expect(dialog(error_message).visible?).to eq(true)
end