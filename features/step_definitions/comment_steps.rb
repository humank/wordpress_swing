Given(/^a subscriber "([^"]*)" logined$/) do |user_name|
	step %Q[there is an existing user named "#{user_name}" and password "s3cr3t"]
	step %Q[login with user name "#{user_name}" and password "s3cr3t"]
end

When(/^she comments a post "([^"]*)" with comment "([^"]*)"$/) do |post_name, comment|
	container.set page_dialog('Dashboard')
	@post_name = post_name
	button(post_name).do_click()
	container.set page_dialog(post_name)
	@comment = comment
  	text_field('comment').text = comment
  	button('post').do_click()
end

Then(/^other subscriber "([^"]*)" can see this comment$/) do |user_name|
  	frame('WordPress-Swing').close()
	Java::com.odde.atdd.demo.view::Main.main([].to_java(:string))
	step %Q[there is an existing user named "#{user_name}" and password "s3cr3t"]
	step %Q[login with user name "#{user_name}" and password "s3cr3t"]
	container.set page_dialog('Dashboard')
	button(@post_name).do_click()
	container.set page_dialog(@post_name)
	expect(label(@comment).visible?).to eq(true)
end