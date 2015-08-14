require_relative 'dependencies_and_sut'

Java::com.odde.atdd.demo::Main.main([].to_java(:string))

at_exit do 
  java.lang.System.exit(0)
end