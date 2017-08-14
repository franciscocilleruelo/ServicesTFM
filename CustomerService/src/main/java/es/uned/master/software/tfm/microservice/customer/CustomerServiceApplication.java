package es.uned.master.software.tfm.microservice.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.uned.master.software.tfm.microservice.customer.service.CustomerService;

@SpringBootApplication
public class CustomerServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceApplication.class);
	
	public static void main(String[] args) {
		log.info("Arrancado microservicio de clientes");
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(CustomerService customerService){
		return args -> {
			customerService.insertExampleData();
			customerService.findAll().forEach(entry -> log.info(entry.toString()));
		};
	}
	
	@Value("${queue.orders.name}")
	private String ordersQueueName;
	
	@Bean
	public Queue ordersQueue(){
		return new Queue(ordersQueueName, false, false, false);
	}
	
	@Value("${queue.customers.name}")
	private String customersQueueName;
	
	@Bean
	public Queue customersQueue(){
		return new Queue(customersQueueName, false, false, false);
	}

}
