package co.jp.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {
 private static Logger log =LogManager.getLogger(MainClass.class);
 
 public static void main(String[] args) {
	MainClass mc = new MainClass();
	mc.doLogMessage();
	mc.loopLogMessage();
}
 
 public void doLogMessage() {
	 log.fatal("Hello, This is Fatal Message");
	 log.error("Hello, This is Error Message");
	 log.warn("Hello, This is Warn Message");
	 log.info("Hello, This is Info Message");
	 log.debug("Hello, This is Debug Message");
	 log.trace("Hello, This is Trace Message");
 }
 
 public void loopLogMessage() {
	 long currentTime = System.currentTimeMillis();
	 long stopTime = currentTime + 10000;
	 while(currentTime < stopTime) {
		 doLogMessage();
		 currentTime = System.currentTimeMillis();
	 }
 }
 
}
