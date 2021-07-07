package com.coderman.PureJDBCExample.dao;


import com.coderman.PureJDBCExample.domain.Person;
import com.coderman.PureJDBCExample.exception.NoSuchPersonException;

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
