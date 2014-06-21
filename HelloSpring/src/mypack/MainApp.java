package mypack;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String args[]) {
		// XmlBeanFactory factory = new XmlBeanFactory(new
		// ClassPathResource("Beans.xml")); // XmlBeanFactory is depricated

		System.out.println("Before Application Context Loading");
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("Beans.xml");

		// AbstractApplicationContext is used here for registerShoutdownHook()
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		System.out.println("After Application Context Loading");

		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

		System.out.println("Message From Bean Configuration: " + obj.getMessage());
		obj.setMessage("How are you?");
		System.out.println("After Message updated using setter: " + obj.getMessage());

		HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld");
		System.out.println("Check the scope of bean(Singleton/Prototype) " + obj2.getMessage());

		HelloEarth he = (HelloEarth) context.getBean("helloEarth");
		System.out.println("From Earth: size=" + he.getSize());
		System.out.println("From Earth: Message: " + he.getMessage());

		context.registerShutdownHook();
	}
}
