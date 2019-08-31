package co.jp.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4j {
	private static Logger logger = LogManager.getLogger(TestLog4j.class);

	 public static void main(String[] args) {
		 TestLog4j mc = new TestLog4j();
			mc.doLogMessage();
		}
		 
		 public void doLogMessage() {
			 logger.fatal("Hello, This is Fatal Message");
			 logger.error("Hello, This is Error Message");
			 logger.warn("Hello, This is Warn Message");
			 logger.info("Hello, This is Info Message");
			 logger.debug("Hello, This is Debug Message");
			 logger.trace("Hello, This is Trace Message");
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
