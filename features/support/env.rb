require 'java'

require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/swinger/lib/swinger'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/commons-cli-1.2.jar'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/commons-collections-3.2.1.jar'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/commons-configuration-1.8.jar'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/commons-lang-2.6.jar'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/commons-logging-1.1.1.jar'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/json-20140107.jar'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/jwordpress-0.6.2.jar'
require '/Users/josephyao/Documents/training_workspace/vagrant-android-develop/WordPress-Swing/lib/xmlrpc-1.1.1.jar'

path = File.expand_path(File.dirname(__FILE__))
require File.expand_path(path + '/../../out/artifacts/WordPress_Swing_jar/WordPress-Swing.jar')

Java::com.odde.atdd.demo::Main.main([].to_java(:string))

at_exit do 
  java.lang.System.exit(0)
end