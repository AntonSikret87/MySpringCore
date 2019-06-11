package ua.epam.spring.core;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.spring.core.beans.MyClient;
import ua.epam.spring.core.beans.Event;
import ua.epam.spring.core.loggers.iEventLogger;

public class App {
	private MyClient myClient;
	private iEventLogger iEventLogger;
	private Event event;


	public App(MyClient myClient, iEventLogger iEventLogger, Event event) {
		this.myClient = myClient;
		this.iEventLogger = iEventLogger;
		this.event = event;
	}

//	private final static String CLIENT_ID = "1";
//	private final static String CLIENT_NAME = "Jhon S";

	public static void main(String[] args) {
		//ua.epam.spring.core.App app = new ua.epam.spring.core.App();

//		app.myClient = new MyClient(CLIENT_ID, CLIENT_NAME);
//		app.eventLogger = new ConsoleEventLogger();
		//app.logEvent("Some event for user 1");

		//ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ConfigurableApplicationContext cnfgComtext = new ClassPathXmlApplicationContext("spring.xml");


		//Resource res = new ClassPathResource("/resources/spring.xml");
		App app = (App) cnfgComtext.getBean("app");
		for (int i = 0; i < 5; i++) {
			app.logEvent("Hello World from user 1!");
		}
		// Instead of context.close() use the hook:
		cnfgComtext.registerShutdownHook();

	//	app.logEvent("Hello World from user 1!");
	}


	private  void logEvent(String msg){
		//String message = msg.replaceAll(myClient.getId(), myClient.getFullName());
		String message = msg.replaceAll(myClient.getId(), myClient.getFullName());
		event.setMsg(message);
		iEventLogger.logEvent(event);
	}
}
