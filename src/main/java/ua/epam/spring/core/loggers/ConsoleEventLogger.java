package ua.epam.spring.core.loggers;

import ua.epam.spring.core.beans.Event;

public class ConsoleEventLogger implements iEventLogger {


	public void logEvent(Event event){
		System.out.println("Yo --> " + event);
	}
}
