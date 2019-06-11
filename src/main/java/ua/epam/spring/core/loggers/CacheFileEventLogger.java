package ua.epam.spring.core.loggers;

import ua.epam.spring.core.beans.Event;

import java.util.ArrayList;
import java.util.List;


public class CacheFileEventLogger extends FileEventLogger {

	private int cacheSize;
	private List<Event> cache;

	public CacheFileEventLogger(int cacheSize, String fileName) {
		super(fileName);
		this.cacheSize = cacheSize;
		cache = new ArrayList<Event>(cacheSize);
	}

	private void writeEventsFromCache() {
		for (Event event : cache) {
			super.logEvent(event);
		}
	}

	public void logEvent(Event event){
		cache.add(event);

		if(cache.size() == cacheSize){
			writeEventsFromCache();
			cache.clear();
		}
	}

	public void destroy(){
		if(!cache.isEmpty()) {
			writeEventsFromCache();
		}
	}
}
