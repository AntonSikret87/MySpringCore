package ua.epam.spring.core.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {

	private int id;
	private String msg;
	private Date date;
	private DateFormat df;


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Event(Date date, DateFormat df) {
		this.id = new Random().nextInt();
		this.date = date;
		this.df = df;
	}

	@Override
	public String toString() {
		return "Event{" +
				"id=" + id +
				", msg='" + msg + '\'' +
				", date=" + df.format(date) +
				'}';
	}
}
