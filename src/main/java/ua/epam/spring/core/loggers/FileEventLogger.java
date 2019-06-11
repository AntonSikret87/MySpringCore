package ua.epam.spring.core.loggers;

import org.apache.commons.io.FileUtils;
import ua.epam.spring.core.beans.Event;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileEventLogger implements iEventLogger {

	private String fileName;

	public FileEventLogger(String fileName) {
		this.fileName = fileName;
	}

	public void logEvent(Event event) {
		try {
			File file = new File(fileName);
			FileUtils.writeStringToFile(file, event.toString()+"\n", Charset.forName("UTF-8"), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void init() throws IOException{
		File file = new File(fileName);
		if (!file.canWrite()) {
			throw new IllegalStateException("Can't write to file " + fileName);
		}
	}
}
