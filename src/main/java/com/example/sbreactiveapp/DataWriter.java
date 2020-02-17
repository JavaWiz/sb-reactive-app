package com.example.sbreactiveapp;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class DataWriter implements ApplicationRunner {
	
	private final CustomerRepository customerRepository;
	
	public DataWriter(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Flux.just("Ranjan", "Rejina", "Rehanshi").flatMap(name -> customerRepository.save(new Customer(null, name)))
		.subscribe(System.out::print);
	}
}
