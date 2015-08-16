require_relative 'dependencies_and_sut'

Java::com.odde.atdd.demo.view::Main.main([].to_java(:string))

at_exit do 
  java.lang.System.exit(0)
end