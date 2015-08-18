Given(/^a subscriber "([^"]*)" logined$/) do |user_name|
	step %Q[there is an existing user named "#{user_name}" and password "s3cr3t"]
	step %Q[login with user name "#{user_name}" and password "s3cr3t"]
end

When(/^she comments a post "([^"]*)" with comment "([^"]*)"$/) do |post_name, comment|
	container.set page_dialog('Dashboard')
	button(post_name).do_click()
	container.set page_dialog(post_name)
  	text_field('comment').text = comment
  	button('post').do_click()
end

Then(/^other user "([^"]*)" can see this comment$/) do |user_name|

end