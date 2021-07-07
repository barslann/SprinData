package com.coderman.purejdbcexample.dao;


import com.coderman.purejdbcexample.domain.Person;
import com.coderman.purejdbcexample.exception.NoSuchPersonException;

import java.util.List;

public interface PersonDAO {
	 void savePerson(Person person);
	 int retrievePersonCount();
	 Person retrievePerson(int id) throws NoSuchPersonException;
	 List<Person> retrieveAllPersons();
	 void updatePersonDOB(Person person);
	 void deletePerson(Person person);
	 void deleteAllPersons();
}
