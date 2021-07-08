package com.coderman.springjpaexample;

import java.util.Date;

import com.coderman.springjpaexample.dao.PersonJpaRepository;
import com.coderman.springjpaexample.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


//@SpringBootApplication
public class Demo implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("User id 10001 -> {}", repository.findById(10001));

        logger.info("Inserting -> {}",
                repository.insert(new Person("Tara", "Berlin", new Date())));

        logger.info("Update 10003 -> {}",
                repository.update(new Person(10003, "Pieter", "Utrecht", new Date())));

        repository.deleteById(10002);

        logger.info("All users -> {}", repository.findAll());
    }
}