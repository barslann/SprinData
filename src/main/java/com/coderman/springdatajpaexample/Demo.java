package com.coderman.springdatajpaexample;

import java.util.Date;

import com.coderman.springdatajpaexample.dao.PersonRepository;
import com.coderman.springdatajpaexample.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Demo implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("User id 10001 -> {}", repository.findById(10001));

        Person person = new Person("as", "Berlin", new Date());
        logger.info("Inserting -> {}", repository.save(person));

        logger.info("Update 10003 -> {}", repository.save(new Person(10003, "ds", "Utrecht", new Date())));

        repository.deleteById(10002);

        logger.info("All users -> {}", repository.findAll());
    }
}