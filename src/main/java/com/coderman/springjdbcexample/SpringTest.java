package com.coderman.springjdbcexample;

import com.coderman.purejdbcexample.dao.PersonDAO;
import com.coderman.purejdbcexample.domain.Factory;
import com.coderman.purejdbcexample.domain.Person;
import com.coderman.springjdbcexample.conf.AppConfig;
import com.coderman.springjdbcexample.conf.JDBCConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import({AppConfig.class, JDBCConfig.class})
public class SpringTest {
	
//	@Autowired
//	@Qualifier("personJdbcConnectionDAO")
//	PersonDAO dao;
	
	@Autowired 
	@Qualifier("personJdbcDataSourceDAO")
	PersonDAO dao;
	
	@Autowired
	Factory personFactory;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringTest.class);
		SpringTest test = context.getBean(SpringTest.class);
		// That's a very naive code that I still keep doing! :)
//		SpringTest test = new SpringTest();
		test.run();
	}
	
	public void run() {
		System.out.println("Number of person: " + dao.retrievePersonCount());
		
//		int id = 1;
//		Person person2 = new Person(id, "Ali", "Ozmen", new Date());
//		dao.savePerson(person2);
		
//		Person personRetrieved = null;
//		try {
//			personRetrieved = dao.retrievePerson(id);
//			System.out.println(personRetrieved);
//		} catch (NoSuchPersonException e) {
//			System.out.println("Person does not exists!");
//			System.out.println(e.getMessage());
//		}
		
//		dao.deletePerson(personRetrieved);
		
//		savePersons(100);
//		List<Person> persons = dao.retrieveAllPersons();
//		for(Person person : persons)
//			System.out.println(person);
		
//		int id = 5;
//		Person person = dao.retrievePerson(id);
//		System.out.println("Before update: " + person);
//		person.setDob(new Date(2000000000));
//		dao.updatePersonDOB(person);
//		person = dao.retrievePerson(id);
//		System.out.println("After update: " + person);	
		
//		dao.deleteAllPersons();
	}
	
	/**
	 * Utility method to populate the database
	 * 
	 * @param n Number of the persons to be created.
	 */
	public void savePersons(int n) {
		System.out.println("\nSaving " + n + " persons to DB");
		for (int i = 0; i < n; i++) {
			Person p = personFactory.createPerson();
			dao.savePerson(p);
		}
	}
}
