package ua.epam.spring.core.loggers;

public class ConsoleEventLogger implements iEventLogger {


	public void logEvent(String msg){
		System.out.println(msg);
	}
}
