package com.demo;

import com.demo.model.Employee;
import com.demo.model.Order;
import com.demo.model.Status;
import com.demo.repository.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
  	CommandLineRunner initDatabase(EmployeeRepository employees, OrderRepository orders) {
		return args -> {
			log.info("");
			log.info("Preloading " + employees.save(new Employee("Bilbo", "Baggins", "burglar")));
			log.info("Preloading " + employees.save(new Employee("Frodo", "Baggins", "thief")));
			log.info("");
			employees.findAll().forEach(employee -> log.info("Preloaded " + employee));

			orders.save(new Order("MacBook Pro", Status.COMPLETED));
			orders.save(new Order("iPhone", Status.IN_PROGRESS));
	  
			orders.findAll().forEach(order -> {
			  log.info("Preloaded " + order);
			});
			/*
			log.info("");
			// save a few customers
			customers.save(new Customer("Jack", "Bauer"));
			customers.save(new Customer("Chloe", "O'Brian"));
			customers.save(new Customer("Kim", "Bauer"));
			customers.save(new Customer("David", "Palmer"));
			customers.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : customers.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = customers.findById(3L);
			log.info("Customer found with findById(3L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			customers.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
			*/

    	};
	}	
}
