package ua.epam.spring.core.loggers;

import ua.epam.spring.core.beans.Event;

public interface iEventLogger {

//	void logEvent(String msg);
	void logEvent(Event event);
}
