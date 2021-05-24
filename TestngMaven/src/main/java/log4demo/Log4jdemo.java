package log4demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jdemo {
	public static Logger log1= LogManager.getLogger(Log4jdemo.class.getName());
	
	public static void main(String[] args)
	{
		System.out.println("Starting");
		log1.trace("Starting to trace");
		log1.info("information");
		log1.error("error");
		log1.warn("warning");
		log1.fatal("fatal");
		
	}

}