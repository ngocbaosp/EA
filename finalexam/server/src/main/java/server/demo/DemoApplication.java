package server.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import server.demo.domain.Person;
import server.demo.service.PersonServiceImpl;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private  PersonServiceImpl personService;

	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		DemoApplication main = context.getBean(DemoApplication.class);
		main.test();




	}

	public void test()
	{
		personService.addPerson(new Person("Bao","Tran",12));
		personService.addPerson(new Person("Quy","Nguyen",20));

		System.out.println(personService.getAll());
	}

}
