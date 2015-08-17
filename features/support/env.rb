require_relative 'dependencies_and_sut'

Before do |scenario|
	Java::com.odde.atdd.demo.view::Main.main([].to_java(:string))
end

After do |scenario|
  	frame('WordPress-Swing').close()
end