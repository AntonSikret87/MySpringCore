package ua.epam.spring.core.beans;

public class MyClient {

	private String id;
	private String fullName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MyClient(String id, String fullName) {
		this.id = id;
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
