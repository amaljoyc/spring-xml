package mypack;

public class HelloWorld {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void init() {
		System.out.println("Inside init method");
	}

	public void destroy() {
		System.out.println("Inside destroy method");
	}
}
