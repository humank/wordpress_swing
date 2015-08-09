require 'java'

path = File.expand_path(File.dirname(__FILE__))
require File.expand_path(path + '/../../out/artifacts/WordPress_Swing_jar/WordPress-Swing.jar')

Java::com.odde.atdd.demo::Main.main([].to_java(:string))

at_exit do 
  java.lang.System.exit(0)
end