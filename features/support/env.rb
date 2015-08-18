require_relative 'dependencies_and_sut'

Before do |scenario|
	Java::com.odde.atdd.demo.view::Main.main([].to_java(:string))
end

def page_dialog(dialog_name)
	container.set frame('WordPress-Swing')
	return dialog(dialog_name)
end

After do |scenario|
  	frame('WordPress-Swing').close()
end