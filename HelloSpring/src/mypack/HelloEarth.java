package mypack;

public class HelloEarth {
	private int size;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void init() {
		System.out.println("Inside init from Earth");
	}
	
	public void destroy() {
		System.out.println("Inside destroy from Earth");
	}
}
