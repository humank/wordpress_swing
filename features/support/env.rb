require 'java'

path = File.expand_path(File.dirname(__FILE__))
# require File.expand_path(path + '/../../../lib/swinger')
puts "file:///#{File.expand_path(path + '/../../out/artifacts/WordPress-Swing/WordPress-Swing.jar')}/"

require File.expand_path(path + '/../../out/artifacts/WordPress_Swing_jar/WordPress-Swing.jar')

# $CLASSPATH << "file:///#{File.expand_path(path + '/../../out/production/WordPress-Swing/')}/"

puts "It takes a while for the scenarios to begin executing, so please be patient..."

#Java::com.odde.atdd.demo::Main.main([].to_java(:string))
Java::com.odde.atdd.demo::Main.main([].to_java(:string))
sleep(1)

at_exit do 
  java.lang.System.exit(0)
end